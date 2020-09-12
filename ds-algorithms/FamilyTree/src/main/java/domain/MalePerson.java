package domain;

public class MalePerson extends Person {

    public MalePerson(String name) {
        super(name);
        setGender("Male");
    }

    public void getChildren(String gender){
        if (this.getSpouse() != null){
            ((FemalePerson)this.getSpouse()).getChildren(gender);
        }
        else{
            System.out.println("NONE");
        }
    }

}
