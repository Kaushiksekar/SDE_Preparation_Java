package com.learning.java.design_patterns.iterator;

class Topic{
    String name;

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface Iterator<E>{
    void reset();
    E next();
    E currentItem();
    boolean hasNext();
}

class TopicIterator implements Iterator<Topic>{

    private Topic[] topic;
    private int position;

    public TopicIterator(Topic[] topic) {
        this.topic = topic;
        position = 0;
    }

    @Override
    public void reset() {
        position = 0;
    }

    @Override
    public Topic next() {
        return topic[position++];
    }

    @Override
    public Topic currentItem() {
        return topic[position];
    }

    @Override
    public boolean hasNext() {
        return position < topic.length;
    }
}

interface List<E>{
    Iterator<E> iterator();
}

class TopicList implements List<Topic>{

    private Topic[] topics;

    public TopicList(Topic[] topics) {
        this.topics = topics;
    }

    @Override
    public Iterator<Topic> iterator() {
        return new TopicIterator(topics);
    }
}

public class IteratorDemo {

    public static void main(String[] args) {

        Topic[] topics = new Topic[5];
        topics[0] = new Topic("CS");
        topics[1] = new Topic("Science");
        topics[2] = new Topic("Math");
        topics[3] = new Topic("Tamil");
        topics[4] = new Topic("English");
        List<Topic> list = new TopicList(topics);
        Iterator<Topic> topicIterator = list.iterator();
        while(topicIterator.hasNext()){
            Topic topic = topicIterator.next();
            System.out.println(topic.getName());
        }

    }
}
