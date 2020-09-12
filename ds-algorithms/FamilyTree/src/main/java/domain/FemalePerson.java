package domain;

import java.util.ArrayList;
import java.util.List;

public class FemalePerson extends Person {

    private List<Person> children;

    public FemalePerson(String name) {
        super(name);
        setGender("Female");
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child){
        if (children == null) {
            children = new ArrayList<Person>();
        }
        children.add(child);
    }

    public void getChildren(String gender){
        if (children == null) {
            System.out.println("NONE");
            return;
        }
        for (Person child: children){
            if (child.getGender().equals(gender)){
                System.out.print(child.getName() + " ");
            }
        }
        System.out.println();
    }

}
