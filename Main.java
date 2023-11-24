import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args) {
        // sumArray();
        // sortArray();
        // employee();
        // linkedList();
        // binaryTree();
        getAPI();
    }

    //Easy
    //1. หาผลบวกของตัวเลขทั้งหมดใน Array
    public static void sumArray(){
        int[] numbers = {10,12,50,11,12,14};
        //way 1 using util.Arrays to sum
        System.out.println(Arrays.stream(numbers).sum());

        //way 2 loop
        int sum = 0;
        for(int i : numbers){
            sum += i;
        }
        System.out.println(sum);
    }

    //2. เขียนโค้ดเพื่อจัดเรียงข้อมูลใน ArrayList ให้เรียงลำดับจากน้อยไปหามาก
    public static void sortArray(){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Integer[] data = {10,12,50,11,12,14};
        Collections.addAll(numbers,data);
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    //Normal
    //1. เขียนโค้ดเพื่อจัดการกับข้อมูลที่เป็น Object ของคลาสต่างๆ เช่นการสร้างคลาสผู้ใช้ (User) และการใช้ Method เพื่อดำเนินการต่างๆ กับ Object นั้นๆ
    public static void employee(){
        User user1 = new User("1", "Chanadee");
        user1.setSalary(50000);
        user1.setJobPos("Programmer");
        user1.displayEmployee();
    }

    //Hard
    //1. เขียนโปรแกรมเพื่อทำการจัดการกับข้อมูลที่เป็นการเชื่อมโยงแบบ LinkedList
    public static void linkedList(){
        LinkedList<String> linkedList = new LinkedList<>();
        // เพิ่มข้อมูลลงใน LinkList
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Orange");
        System.out.printf("LinkedList: %s%n", linkedList);
        
        // เพิ่มข้อมูลระหว่าง Apple banana
        int index = linkedList.indexOf("Banana");
        linkedList.add(index,"Coconut");
        System.out.printf("LinkedList after add Coconut: %s%n", linkedList);
        
        // ลบข้อมูล Coconut
        linkedList.remove("Coconut");
        System.out.printf("LinkedList after remove Coconut: %s%n", linkedList);
    }
    
    //2. เขียนโปรแกรมเพื่อทำการจัดการกับข้อมูลที่เป็นการเชื่อมโยงแบบ BinaryTree
    public static void binaryTree(){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(8);
        binaryTree.insert(2);
        binaryTree.insert(4);
        binaryTree.insert(15);
        binaryTree.insert(17);
        binaryTree.insert(13);
        System.out.print("Inorder traversal of binary tree: ");
        binaryTree.inorderTraversal(binaryTree.root);
    }

    //3. เขียนโค้ดเพื่อดึงข้อมูลจาก API ภายนอกและประมวลผลข้อมูล
    public static void getAPI(){
        try {
            //url from serverAPI folder
            String apiUrl = "http://localhost:8000/sum/10&50";
            URI uri = new URI(apiUrl);

            URL url = uri.toURL();

            //connecting to url
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //set request to be get method
            connection.setRequestMethod("GET");

            //read data from url
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null){
                response.append(line + "\n");
            }

            reader.close();
            connection.disconnect();
            System.out.println("Data : " + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
