package com.example.candidate.data;



public class Candidate {

    private int cid;

    private String cname;

    private int age;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPrev_position() {
        return prev_position;
    }

    public void setPrev_position(String prev_position) {
        this.prev_position = prev_position;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    private int experience;

    private String prev_position;

    private String qualifications;
}
