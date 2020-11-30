package com.learning.java.design_patterns.strategy;

interface ISocialMediaStrategy{
    public void connectTo(String friendName);
}

class SocialMediaContext{
    ISocialMediaStrategy socialMediaStrategy;
    public void setSocialMediaStrategy(ISocialMediaStrategy socialMediaStrategy) {
        this.socialMediaStrategy = socialMediaStrategy;
    }
    public void connect(String name){
        socialMediaStrategy.connectTo(name);
    }
}

class FacebookSocialMediaStrategy implements ISocialMediaStrategy{
    @Override
    public void connectTo(String friendName) {
        System.out.println("Connected to " + friendName + " through Facebook");
    }
}

class OrkutSocialMediaStrategy implements ISocialMediaStrategy{
    @Override
    public void connectTo(String friendName) {
        System.out.println("Connected to " + friendName + " through Orkut");
    }
}

public class StrategyPatternDemo {

    public static void main(String[] args) {

        ISocialMediaStrategy facebookSocialMediaStrategy = new FacebookSocialMediaStrategy();
        SocialMediaContext context = new SocialMediaContext();
        context.setSocialMediaStrategy(facebookSocialMediaStrategy);
        context.connect("Sony");
        ISocialMediaStrategy orkutSocialMediaStrategy = new OrkutSocialMediaStrategy();
        context.setSocialMediaStrategy(orkutSocialMediaStrategy);
        context.connect("Sony");

    }
}
