// Risith Kankanamge
// P2
// Zero-Hero
// 10/01/2025

/*
 * DESCRIPTION: PTSA that raises money and plans new projects when goals are met
 * INPUT: Organization name and fundraising goal
 * OUTPUT: Fundraising progress and project planning
 * EDGE CASE: PTSA reaching goal and starting bigger projects
 */

package edu.bhscs;

public class PTSA {
    // fields / properties
    String organizationName;
    double totalFunds;
    double fundraisingGoal;
    int eventsSupported;
    boolean goalReached;
    String currentProject;

    // Constructor
    public PTSA(String organizationName, double fundraisingGoal) {
        this.organizationName = organizationName;
        this.totalFunds = 0.0;
        this.fundraisingGoal = fundraisingGoal;
        this.eventsSupported = 0;
        this.goalReached = false;
        this.currentProject = "School Equipment Fund";
        System.out.println(organizationName + " has started fundraising! Goal: $" + fundraisingGoal + " for the " + currentProject);
    }

    // Methods

    // Get organization name
    String getOrganizationName() {
        return this.organizationName;
    }

    // Get total funds collected
    double getTotalFunds() {
        return this.totalFunds;
    }

    // Get fundraising goal
    double getFundraisingGoal() {
        return this.fundraisingGoal;
    }

    // Check if goal has been reached
    boolean isGoalReached() {
        return this.goalReached;
    }

    // Receive money from cake sales
    void receiveDonation(double amount, String source) {
        totalFunds += amount;
        System.out.println(organizationName + " receives $" + amount + " from " + source + "! Total funds: $" + totalFunds + " / $" + fundraisingGoal);

        // Check progress towards goal
        double progressPercentage = (totalFunds / fundraisingGoal) * 100;
        if (progressPercentage >= 50 && progressPercentage < 75) {
            System.out.println("Great! We're halfway to our goal!");
        } else if (progressPercentage >= 75 && progressPercentage < 100) {
            System.out.println("Almost there! We're three-quarters to our goal!");
        }

        // Goal reached
        if (totalFunds >= fundraisingGoal && !goalReached) {
            goalReached = true;
            System.out.println("CONGRATULATIONS! " + organizationName + " has reached their fundraising goal! The " + currentProject + " can now be funded!");
            planNextProject();
        }
    }

    // Plan the next fundraising project after reaching goal
    void planNextProject() {
        eventsSupported++;

        // Set new project based on events supported (meaningful change)
        if (eventsSupported == 1) {
            currentProject = "Library Enhancement";
            fundraisingGoal = fundraisingGoal * 1.2; // Increase goal for bigger project
        } else if (eventsSupported == 2) {
            currentProject = "Sports Equipment";
            fundraisingGoal = fundraisingGoal * 1.1;
        } else {
            currentProject = "Arts & Music Program";
            fundraisingGoal = fundraisingGoal * 1.3;
        }

        goalReached = false; // Reset for new goal
        System.out.println("New project planned: " + currentProject + ". New fundraising goal: $" + String.format("%.2f", fundraisingGoal));
    }

    // Organize a special fundraising event
    void organizeEvent(String eventName) {
        System.out.println(organizationName + " is organizing a " + eventName + " fundraising event!");

        // Event generates additional funds
        double eventProceeds = 50.0 + (Math.random() * 100); // Random between $50-$150
        totalFunds += eventProceeds;

        System.out.println("The " + eventName + " raised an additional $" + String.format("%.2f", eventProceeds) + "! Updated total funds: $" + String.format("%.2f", totalFunds));

        // Check if this pushes us over the goal
        if (totalFunds >= fundraisingGoal && !goalReached) {
            goalReached = true;
            System.out.println("The " + eventName + " helped us reach our goal");
            planNextProject();
        }
    }

    // Allocate funds for school improvements
    void allocateFunds(double amount, String purpose) {
        if (totalFunds >= amount) {
            totalFunds -= amount;
            System.out.println(organizationName + " allocates $" + amount + " for " + purpose + ". Remaining funds: $" + String.format("%.2f", totalFunds));
        } else {
            System.out.println("Insufficient funds! Need $" + (amount - totalFunds) + " more for " + purpose);
        }
    }

    // Display current PTSA status and progress
    void showPTSAStatus() {
        System.out.println("=== PTSA STATUS ===\nOrganization: " + organizationName + "\nCurrent Project: " + currentProject + "\nTotal Funds Raised: $" + String.format("%.2f", totalFunds) + "\nFundraising Goal: $" + String.format("%.2f", fundraisingGoal) + "\nGoal Reached: " + goalReached + "\nEvents Supported: " + eventsSupported);

        if (!goalReached) {
            double remaining = fundraisingGoal - totalFunds;
            double percentage = (totalFunds / fundraisingGoal) * 100;
            System.out.println("Progress: " + String.format("%.1f", percentage) + "% complete\nStill needed: $" + String.format("%.2f", remaining));
        }
        System.out.println("=================");
    }
}
