package com.verros.resources;


import com.verros.messageModel.Profile;
import com.verros.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResources {

    ProfileService profileService = new ProfileService();

    @GET
    public List<Profile> getProfiles(){
        return profileService.getAllProfiles();
    }

    @POST
    public Profile addProfile(Profile profile){
        return profileService.addProfile(profile);
    }

    @PUT
    @Path("/{name}")
    public Profile putProfile(@PathParam("name") String name, Profile profile){
        profile.setProfileName(name);
        return profileService.updateProfile(profile);
    }


}
