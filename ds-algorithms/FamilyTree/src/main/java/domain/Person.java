package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Person {

    private String gender;
    private String name;
    private Person spouse;
    private Person parent;

    public Person(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person getParent() {
        return parent;
    }

    public void setParent(Person parent) {
        this.parent = parent;
    }

    public abstract void getChildren(String gender);

    private List<Person> getSiblings(){
        if (this.getParent() == null){
            return null;
        }
        FemalePerson mother = (FemalePerson) this.getParent();
        List<Person> children = mother.getChildren();
        if (children == null || children.size() == 0){
            return null;
        }
        if(children.stream().filter(person -> !person.getName().equals(this.getName())).count() == 0){
            return null;
        }
        return children.stream().filter(person -> !person.getName().equals(this.getName())).collect(Collectors.toList());
    }

    public void getSiblings(String gender){
        List<Person> siblings = this.getSiblings();
        if (siblings == null){
            System.out.println("NONE");
            return;
        }
        siblings.stream().forEach(
                person -> {
                    if (gender.equals("Both")){
                        System.out.print(person.getName() + " ");
                    }
                    else{
                        if (person.getGender().equals(gender)){
                            System.out.print(person.getName() + " ");
                        }
                    }
                }
        );
        System.out.println();
    }

    public void getUncleOrAunt(String type, String gender){
        Person mother = this.getParent();
        if (type.equals("Paternal")){
            Person father = mother.getSpouse();
            if (father == null){
                System.out.println("NONE");
                return;
            }
            father.getSiblings(gender);
            return;
        }
        else{
            mother.getSiblings(gender);
        }
    }

    public void getInLaws(String gender){
        // this covers spouses' male or female siblings
        List<Person> inLaws = new ArrayList<>();
        if (this.getSpouse() != null){
            for (Person spouseSibling: this.getSpouse().getSiblings()){
                if (spouseSibling.getGender().equals(gender)){
                    inLaws.add(spouseSibling);
                }
            }
        }
        if (this.getSiblings() != null){
            List<Person> siblings = this.getSiblings();
            for (Person sibling: siblings){
                if (sibling.getSpouse() != null){
                    if (!sibling.getGender().equals(gender))
                        inLaws.add(sibling.getSpouse());
                }
            }
        }

        if (inLaws.size() == 0){
            System.out.println("NONE");
            return;
        }
        for (Person inLaw: inLaws){
            System.out.print(inLaw.getName() + " ");
        }
        System.out.println();

    }
}
