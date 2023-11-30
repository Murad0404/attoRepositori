package service;

import controller.UserController;
import dto.Profile;
import enums.ProfilStatus;
import repository.ProfileRepasitory;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class ProfileService {

    public static Integer profileGolobal;
    public void addProfile(Profile profile) {

        profile.setCreated_date(LocalDateTime.now());
        profile.setStatus(ProfilStatus.NOT_ACTIVE);
        profile.setRole(ProfilStatus.USER);

        ProfileRepasitory profileRepasitory = new ProfileRepasitory();
        profileRepasitory.create(profile);
    }
    public void searchProfileLogin(String password, String phone){
        ProfileRepasitory profileRepasitory = new ProfileRepasitory();
        List<Profile> dtoList = new LinkedList<>(profileRepasitory.search(phone));
        Profile profile = dtoList.get(0);
        profileGolobal = ((profile.getId()));
            if (profile.getPassword().equals(password)){
                profileRepasitory.loginUpdateStatusACTIVE(profile.getId());
                UserController userController = new UserController();
                userController.start();
            }else {
                System.out.println("bunday user topilmadi !");
            }
    }

}
