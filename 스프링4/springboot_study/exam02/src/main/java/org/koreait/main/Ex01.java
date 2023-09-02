package org.koreait.main;

import org.koreait.constants.Role;

public class Ex01 {
    public static void main(String[] args) {
        Role role1 = Role.USER;
        Role role2 = Role.ADMIN;
        System.out.println("role1 : " + role1.ordinal());
        System.out.println("role2 : " + role2.ordinal());
    }
}
