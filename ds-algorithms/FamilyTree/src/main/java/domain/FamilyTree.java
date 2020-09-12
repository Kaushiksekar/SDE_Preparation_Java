package domain;

public class FamilyTree {

    private Person femaleRoot;

    public FamilyTree(String femaleRootName, String maleRootName) {
        femaleRoot = new FemalePerson(femaleRootName);
        Person maleRoot = new MalePerson(maleRootName);
        femaleRoot.setSpouse(maleRoot);
        maleRoot.setSpouse(this.femaleRoot);
    }

    public void addSpouse(String personName, String spouseName){
        Person person = getPerson(femaleRoot, personName);
        if (person == null){
            System.out.println("PERSON_NOT_FOUND");
            return;
        }
        Person spouse;
        // this if-else is not because I'm anti-gay. It's just to keep the problem and design as simple as possible
        // Apologies to the homosexual community
        if (person.getGender().equals("Male")){
            spouse = new FemalePerson(spouseName);
        }
        else{
            spouse = new MalePerson(spouseName);
        }
        person.setSpouse(spouse);
        spouse.setSpouse(person);
    }

    public void getAndPrintRelatives(String personName, String relationship){
        Person person = getPerson(femaleRoot, personName);
        if (person == null){
            System.out.println("PERSON_NOT_FOUND");
            return;
        }
        switch (relationship){
            case "Paternal-Uncle":
                person.getUncleOrAunt("Paternal", "Male");
                break;
            case "Maternal-Uncle":
                person.getUncleOrAunt("Maternal", "Male");
                break;
            case "Paternal-Aunt":
                person.getUncleOrAunt("Paternal", "Female");
                break;
            case "Maternal-Aunt":
                person.getUncleOrAunt("Maternal", "Female");
                break;
            case "Sister-In-Law":
                person.getInLaws("Female");
                break;
            case "Brother-In-Law":
                person.getInLaws("Male");
                break;
            case "Son":
                person.getChildren("Male");
                break;
            case "Daughter":
                person.getChildren("Female");
                break;
            case "Siblings":
                person.getSiblings("Both");
                break;
        }
    }

    private Person getPerson(Person person, String personName){
        if(person.getName().equals(personName)){
            return person;
        }
        else if (person.getSpouse() != null && person.getSpouse().getName().equals(personName)){
            return person.getSpouse();
        }
        if (person.getGender().equals("Male")){
            if (person.getSpouse() != null){
                person = person.getSpouse();
            }
            else{
                return null;
            }
        }
        if (((FemalePerson)person).getChildren()!=null){
            for(Person child: ((FemalePerson)person).getChildren()){
                Person personFound = getPerson(child, personName);
                if (personFound != null){
                    return personFound;
                }
            }
        }
        return null;

    }

    public void addChild(String motherName, String childName, String gender){
        Person person = getPerson(femaleRoot, motherName);
        if (person == null){
            System.out.println("PERSON_NOT_FOUND");
            return;
        }
        if (person.getGender().equals("Male")){
            System.out.println("CHILD_ADDITION_FAILED");
            return;
        }
        setUpChildParentRelation(person, childName, gender);
    }

    private void setUpChildParentRelation(Person currentPerson, String childName, String gender){
        FemalePerson mother = (FemalePerson) currentPerson;
        Person child;
        if (gender.equals("Male")){
            child = new MalePerson(childName);
        }
        else{
            child = new FemalePerson(childName);
        }
        mother.addChild(child);
        child.setParent(mother);
        System.out.println("CHILD_ADDITION_SUCCEEDED");
    }

}
