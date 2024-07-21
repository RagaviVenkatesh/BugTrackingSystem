
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controller.BugTrackingController;
import model.Bug;
import model.Category;
import model.Developer;

public class Main {

	public static void main(String[] args) {
		
		BugTrackingController controller = new BugTrackingController();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Bug Tracking System");
            System.out.println("1. Add Category");
            System.out.println("2. Update Category");
            System.out.println("3. Delete Category");
            System.out.println("4. List All Categories");
            System.out.println("5. Add Developer");
            System.out.println("6. Update Developer");
            System.out.println("7. Delete Developer");
            System.out.println("8. List All Developers");
            System.out.println("9. Add Bug");
            System.out.println("10. Update Bug");
            System.out.println("11. Delete Bug");
            System.out.println("12. List All Bugs");
            System.out.println("13. List Bugs with Category Names");
            System.out.println("14. List Bugs Assigned to Developer");
            System.out.println("15. Bug Counts by Developer");
            System.out.println("16. Bugs with Developer Details");
            System.out.println("17. Bugs Resolved in Time Frame");
            System.out.println("18. Developer with Most Bugs Assigned");
            System.out.println("19. List Bugs by Category");
            System.out.println("20. Max Bugs Assigned to a Developer");
            System.out.println("21. Developers with Resolved Bugs Above Threshold");
            System.out.println("22. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter category name: ");
                        String categoryName = scanner.nextLine();
                        controller.addCategory(new Category(0, categoryName));
                        System.out.println("Category added.");
                        break;
                    case 2:
                        System.out.print("Enter category ID to update: ");
                        int updateCategoryId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new category name: ");
                        String newCategoryName = scanner.nextLine();
                        controller.updateCategory(new Category(updateCategoryId, newCategoryName));
                        System.out.println("Category updated.");
                        break;
                    case 3:
                        System.out.print("Enter category ID to delete: ");
                        int deleteCategoryId = scanner.nextInt();
                        scanner.nextLine();
                        controller.deleteCategory(deleteCategoryId);
                        System.out.println("Category deleted.");
                        break;
                    case 4:
                        List<Category> categories = controller.getAllCategories();
                        for (Category category : categories) {
                            System.out.println("ID: " + category.getCategoryId() + ", Name: " + category.getCategoryName());
                        }
                        break;
                    case 5:
                        System.out.print("Enter developer name: ");
                        String developerName = scanner.nextLine();
                        System.out.print("Enter developer email: ");
                        String developerEmail = scanner.nextLine();
                        controller.addDeveloper(new Developer(0, developerName, developerEmail));
                        System.out.println("Developer added.");
                        break;
                    case 6:
                        System.out.print("Enter developer ID to update: ");
                        int updateDeveloperId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new developer name: ");
                        String newDeveloperName = scanner.nextLine();
                        System.out.print("Enter new developer email: ");
                        String newDeveloperEmail = scanner.nextLine();
                        controller.updateDeveloper(new Developer(updateDeveloperId, newDeveloperName, newDeveloperEmail));
                        System.out.println("Developer updated.");
                        break;
                    case 7:
                        System.out.print("Enter developer ID to delete: ");
                        int deleteDeveloperId = scanner.nextInt();
                        scanner.nextLine();
                        controller.deleteDeveloper(deleteDeveloperId);
                        System.out.println("Developer deleted.");
                        break;
                    case 8:
                        List<Developer> developers = controller.getAllDevelopers();
                        for (Developer developer : developers) {
                            System.out.println("ID: " + developer.getDeveloperId() + ", Name: " + developer.getName() + ", Email: " + developer.getEmail());
                        }
                        break;
                    case 9:
                        System.out.print("Enter bug description: ");
                        String bugDescription = scanner.nextLine();
                        System.out.print("Enter category ID: ");
                        int categoryId = scanner.nextInt();
                        System.out.print("Enter assigned developer ID: ");
                        int assignedTo = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        controller.addBug(new Bug(0, bugDescription, categoryId, assignedTo, "Open", new Date(), null));
                        System.out.println("Bug added.");
                        break;
                    case 10:
                        System.out.print("Enter bug ID to update: ");
                        int updateBugId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new bug description: ");
                        String newBugDescription = scanner.nextLine();
                        System.out.print("Enter new category ID: ");
                        int newCategoryId = scanner.nextInt();
                        System.out.print("Enter new assigned developer ID: ");
                        int newAssignedTo = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new status: ");
                        String newStatus = scanner.nextLine();
                        System.out.print("Enter new resolved date (yyyy-mm-dd hh:mm:ss) or leave blank if not resolved: ");
                        String resolvedDateStr = scanner.nextLine();
                        Timestamp resolvedDate = resolvedDateStr.isEmpty() ? null : Timestamp.valueOf(resolvedDateStr);
                        controller.updateBug(new Bug(updateBugId, newBugDescription, newCategoryId, newAssignedTo, newStatus, null, resolvedDate));
                        System.out.println("Bug updated.");
                        break;
                    case 11:
                        System.out.print("Enter bug ID to delete: ");
                        int deleteBugId = scanner.nextInt();
                        scanner.nextLine();
                        controller.deleteBug(deleteBugId);
                        System.out.println("Bug deleted.");
                        break;
                    case 12:
                        List<Bug> bugs = controller.getAllBugs();
                        for (Bug bug : bugs) {
                            System.out.println("ID: " + bug.getBugId() + ", Description: " + bug.getDescription() + ", Category ID: " + bug.getCategoryId() + ", Assigned To: " + bug.getAssignedTo() + ", Status: " + bug.getStatus() + ", Created Date: " + bug.getCreatedDate() + ", Resolved Date: " + bug.getResolvedDate());
                        }
                        break;
                    case 13:
                        List<Bug> bugsWithCategoryNames = controller.getAllBugsWithCategoryNames();
                        for (Bug bug : bugsWithCategoryNames) {
                            System.out.println(bug.getDescription());
                        }
                        break;
                    case 14:
                        System.out.print("Enter developer name: ");
                        String devName = scanner.nextLine();
                        List<Bug> bugsAssignedToDev = controller.getBugsAssignedToDeveloper(devName);
                        for (Bug bug : bugsAssignedToDev) {
                            System.out.println(bug.getDescription());
                        }
                        break;
                    case 15:
                        List<String> bugCountsByDeveloper = controller.getBugCountsByDeveloper();
                        for (String entry : bugCountsByDeveloper) {
                            System.out.println(entry);
                        }
                        break;
                    case 16:
                        List<String> bugsWithDeveloperDetails = controller.getBugsWithDeveloperDetails();
                        for (String entry : bugsWithDeveloperDetails) {
                            System.out.println(entry);
                        }
                        break;
                    case 17:
                        System.out.print("Enter start time (yyyy-mm-dd hh:mm:ss): ");
                        String start = scanner.nextLine();
                        System.out.print("Enter end time (yyyy-mm-dd hh:mm:ss): ");
                        String end = scanner.nextLine();
                        Timestamp startTime = Timestamp.valueOf(start);
                        Timestamp endTime = Timestamp.valueOf(end);
                        List<Bug> bugsResolvedInTimeFrame = controller.getBugsResolvedInTimeFrame(startTime, endTime);
                        for (Bug bug : bugsResolvedInTimeFrame) {
                            System.out.println(bug.getDescription());
                        }
                        break;
                    case 18:
                        List<Developer> developersWithMostBugs = controller.getDevelopersWithMostBugsAssigned();
                        for (Developer developer : developersWithMostBugs) {
                            System.out.println(developer.getName());
                        }
                        break;
                    case 19:
                        System.out.print("Enter category name: ");
                        String catName = scanner.nextLine();
                        List<Bug> bugsByCategory = controller.getBugsByCategoryName(catName);
                        for (Bug bug : bugsByCategory) {
                            System.out.println(bug.getDescription());
                        }
                        break;
          
                    case 20:
                        int maxBugsAssigned = controller.getMaxBugsAssignedToDeveloper();
                        System.out.println("Maximum bugs assigned to a single developer: " + maxBugsAssigned);
                        break;
                    case 21:
                        System.out.print("Enter the threshold number of resolved bugs: ");
                        int threshold = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        List<Developer> developersAboveThreshold = controller.getDevelopersWithResolvedBugsAboveThreshold(threshold);
                        for (Developer developer : developersAboveThreshold) {
                            System.out.println(developer.getName() + " has resolved more than " + threshold + " bugs");
                        }
                        break;
                    case 22:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

	}

}
