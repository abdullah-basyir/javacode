public class AplikasiTodolist {
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
    //tesShowTodoList();
    //testAddTodolist();
    //tesRemoveTodoList();
    //tesInput();
    //tesViewShowTodoList();
    //testViewAddTodoList();
    //testViewRemoveTodoList();
    viewShowTodoList();

    }

    /**
     * Menampilkan TodoList
     */
    public static void showTodoList (){
        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++){
            //String todo = model[i];
            var todo = model[i];
            var no = i+1;

            if (todo != null){
                System.out.println(no+"."+" "+ todo);
            }
        }
    }

    public static void tesShowTodoList (){
        model[0] = "Ayam";
        model[1] = "Bubur";
        showTodoList();
    }

    /**
     * Menambah TodoList
     */
    public static void addTodoList(String todo){
        //cek apakah model penuh ?
        var penuh = true;
        for (var i = 0; i < model.length; i++){
            if (model[i] == null){
                //model masih ada yang kosong
                penuh = false;
                break;
            }
        }
        //jika penuh, maka resize 2x lipat
        if (penuh){
            String temp[]= model;
            model = new String[model.length*2];
            for (int i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }
        //tambahkan ke posisi yang data array nya NULL
        for (var i = 0; i < model.length; i++){
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }
    public static void testAddTodolist(){
        for (int i = 0; i < 25; i++){
            addTodoList("Contoh ke ." +i);
        }
        showTodoList();
    }
    /**
     * Menghapus TodoList
     */
    public static boolean removeTodoList(Integer number){
    if ((number-1) >= model.length)
        {
            return false;
        }
    else if (model[number-1] == null)
        {
            return false;
        }
    else
        {
//            model[number-1] = null; --> method lama
//            return true;
            for (int i = (number-1); i<model.length; i++){
                if (i == model.length - 1){
                    model[i] = null;
                }
                else {
                    model[i] = model[i+1];
                }
            }
        }
        return true;
    }
    public static void tesRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("LIma");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    /**
     * Menerima input data
     */
    public static String input(String info){
        System.out.print(info + " : ");
        String data =  scanner.nextLine();
        return data;
    }
    public static void tesInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

        var posisi = input("Posisi");
        System.out.println(posisi);
    }
    /**
     * Menampilkan todolist
     */
    public static void viewShowTodoList(){
        while (true){
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")){
                viewAddTodoList();
            }
            else if (input.equals("2")){
                viewRemoveTodoList();
            }
            else if (input.equals("x")){
                break;
            }
            else {
                System.out.println("Pilihan Tidak Ada di Menu");
            }
        }
    }
    public static void tesViewShowTodoList (){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("lima");

        viewShowTodoList();
    }
    /**
     * menampilkan add todolist
     */
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x jika batal)");

        if (todo.equals("x")){
            //batal
        }
        else {
            addTodoList(todo);
        }
    }
    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        viewAddTodoList();

        showTodoList();
    }

    /**
     * menampilkan hapus todolist
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang dihapus (x jika batal)");

        if (number.equals("x")){
            //batal
        }
        else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success){
                System.out.println("Gagal menghapus todolist" + number);
        }
        }
    }
    public static void testViewRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
