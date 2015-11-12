/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.preparation_threadpoolcallables;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bbalt
 */
public class Group {
    String authors;
    String classCBA;
    int groupNumb;

    public Group(String authors, String classCBA, int group) {
        this.authors = authors;
        this.classCBA = classCBA;
        this.groupNumb = group;
    }

    Group() {

    }

    public Group fixGroup(String groupInfo) {
        String[] parts;
        parts = groupInfo.split("#");
        int gNumber = 0;
        if (parts != null) {
            if (parts[2].matches(".*\\d.*")) {
                gNumber = Integer.parseInt(parts[2].replaceAll("[^0-9]", ""));
            } else {
                gNumber = 0;
            }
            return new Group(parts[0], parts[1], gNumber);
        } else {
            return null;
        }
    }

}
