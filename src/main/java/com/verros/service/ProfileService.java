package com.verros.service;

import com.verros.database.DatabaseClass;
import com.verros.messageModel.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {


    public static Map<String, Profile> profiles = DatabaseClass.getProfile();

    public ProfileService(){
        profiles.put( "mgv", new Profile(1, "mgv", "Mike", "Verros") );
        profiles.put( "kk", new Profile(2, "kk", "Gerge", "Dimou") );
    }

    public List<Profile> getAllProfiles(){
        return  new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfiles(long id){
        return profiles.get(id);
    }

    public Profile addProfile(Profile profile){
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName() , profile);
        return profile;
    }

    public Profile updateProfile(Profile profile){
        profiles.put(profile.getProfileName() , profile);
        return profile;
    }

    public Profile removeProfile(long id){
        return profiles.remove(id);
    }

}
