import domain.FamilyTree;

import java.io.*;

public class Main {

    public static FamilyTree setUpFamilyTree(){
        FamilyTree familyTree = new FamilyTree("Queen Anga", "King Shan");
        familyTree.addChild("Queen Anga", "Chit", "Male");
        familyTree.addSpouse("Chit", "Amba");
        familyTree.addChild("Queen Anga", "Ish", "Male");
        familyTree.addChild("Queen Anga", "Vich", "Male");
        familyTree.addSpouse("Vich", "Lika");
        familyTree.addChild("Queen Anga", "Aras", "Male");
        familyTree.addSpouse("Aras", "Chitra");
        familyTree.addChild("Queen Anga", "Satya", "Female");
        familyTree.addSpouse("Satya", "Vyan");
        familyTree.addChild("Amba", "Dritha", "Female");
        familyTree.addSpouse("Dritha", "Jaya");
        familyTree.addChild("Dritha", "Yodhan", "Male");
        familyTree.addChild("Amba", "Tritha", "Female");
        familyTree.addChild("Amba", "Vritha", "Male");
        familyTree.addChild("Lika", "Vila", "Female");
        familyTree.addChild("Lika", "Chika", "Female");
        familyTree.addChild("Chitra", "Jnki", "Female");
        familyTree.addChild("Chitra", "Ahit", "Male");
        familyTree.addSpouse("Jnki", "Arit");
        familyTree.addChild("Jnki", "Lavanya", "Female");
        familyTree.addChild("Jnki", "Laki", "Male");
        familyTree.addChild("Satya", "Asva", "Male");
        familyTree.addChild("Satya", "Vyas", "Male");
        familyTree.addChild("Satya", "Atya", "Female");
        familyTree.addSpouse("Asva", "Satvy");
        familyTree.addChild("Satvy", "Vasa", "Male");
        familyTree.addSpouse("Vyas", "Krpi");
        familyTree.addChild("Krpi", "Kriya", "Male");
        familyTree.addChild("Krpi", "Kriti", "Female");

        return familyTree;
    }

    public static void main(String[] args) throws IOException {

        FamilyTree familyTree = setUpFamilyTree();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while((line= bufferedReader.readLine()) != null){
            String[] arguments = line.split(" ");
            if (arguments[0].equals("ADD_CHILD")){
                familyTree.addChild(arguments[1], arguments[2], arguments[3]);
            }
            else{
                familyTree.getAndPrintRelatives(arguments[1], arguments[2]);
            }
        }



//        System.out.println("----------------------------Test----------------------------");
//
//        familyTree.addChild("Chitra", "Aria", "Female");
//        familyTree.getAndPrintRelatives("Lavanya", "Maternal-Aunt");
//        familyTree.getAndPrintRelatives("Aria", "Siblings");
//
//        System.out.println("----------------------------Sample 1----------------------------");
//
//        familyTree.addChild("Pjali", "Srutak", "Male");
//        familyTree.getAndPrintRelatives("Pjali", "Son");
//
//        System.out.println("----------------------------Sample 2----------------------------");
//
//        familyTree.addChild("Asva", "Vani", "Female");
//        familyTree.getAndPrintRelatives("Vasa", "Siblings");
//
//        System.out.println("----------------------------Sample 3----------------------------");
//        familyTree.getAndPrintRelatives("Atya", "Sister-In-Law");
//
//        System.out.println("----------------------------Own testing 1----------------------------");
//        familyTree.getAndPrintRelatives("Jaya", "Brother-In-Law");
//
//        System.out.println("----------------------------Own testing 2----------------------------");
//        familyTree.getAndPrintRelatives("Ahit", "Brother-In-Law");
//
//        System.out.println("----------------------------Own testing 3----------------------------");
//        familyTree.getAndPrintRelatives("Atya", "Sister-In-Law");
//
//        System.out.println("----------------------------Own testing 4----------------------------");
//        familyTree.getAndPrintRelatives("Satvy", "Sister-In-Law");
//
//        System.out.println("----------------------------Own testing 5----------------------------");
//        familyTree.getAndPrintRelatives("Chika", "Paternal-Uncle");

    }

}
