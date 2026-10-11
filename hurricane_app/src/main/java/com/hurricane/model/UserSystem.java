package com.hurricane.model;
import java.time.LocalDate;
import java.util.ArrayList;

public class UserSystem {
    private UserList userList = UserList.getInstance();
    private User currentUser;
    private ArrayList<ReliefRequest> reliefRequests = ReliefRequestList.getInstance().getReliefRequests();
    private ArrayList<Shelter> shelters = ShelterList.getInstance().getShelters();
    private ArrayList<Volunteer> volunteers = UserList.getInstance().getVolunteers();
    private Hurricane currentHurricane;
    


    public User login(String userName, String password){
        currentUser = userList.getUser(userName, password);
        return currentUser;
    }

    public User signup(String firstName, String lastName, LocalDate birthDate, String userName, String password, String email){
        userList.addUser(firstName, lastName, birthDate, userName, password, email);
        return userList.getUser(userName, password);
    }

    public ArrayList<User> getUsers() {
        return userList.getUsers();
    }

    public ArrayList<Shelter> getShelters() {
        return ShelterList.getInstance().getShelters();
    }

    public ArrayList<ShelterManager> getShelterManagers(Shelter shelter) {
        return shelter.getShelterManagers();
    }

    public ArrayList<Volunteer> getVolunteers() {
        return userList.getVolunteers();
    }

    public ArrayList<ReliefRequest> getReliefRequests() {
        return reliefRequests;
    }

    public void acceptReliefRequest(ReliefRequest request) {
        request.setStatus(Status.IN_PROGRESS);
    }
}
