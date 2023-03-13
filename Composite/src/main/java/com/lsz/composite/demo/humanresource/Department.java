package com.lsz.composite.demo.humanresource;

import java.util.ArrayList;
import java.util.List;

public class Department extends HumanResource {

    private List<HumanResource> humanResources;

    public Department(long id) {
        super(id);
        humanResources = new ArrayList<>();
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0;
        for (HumanResource humanResource : humanResources) {
            totalSalary += humanResource.calculateSalary();
        }
        return totalSalary;
    }

    public void addHumanResource(HumanResource humanResource) {
        humanResources.add(humanResource);
    }

    public void removeHumanResource(HumanResource humanResource) {
        int curator = 0;
        for (HumanResource hr : humanResources) {
            if (Long.compare(hr.getId(), humanResource.getId()) == 0) {
                humanResources.remove(curator);
                break;
            }
            curator++;
        }
    }
}
