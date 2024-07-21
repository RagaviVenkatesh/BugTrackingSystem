package controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import dao.BugDAO;
import dao.CategoryDAO;
import dao.DeveloperDAO;
import model.Bug;
import model.Category;
import model.Developer;

public class BugTrackingController {
	
	private final BugDAO bugDAO;
    private final CategoryDAO categoryDAO;
    private final DeveloperDAO developerDAO;
    
    public BugTrackingController() {
        this.bugDAO = new BugDAO();
        this.categoryDAO = new CategoryDAO();
        this.developerDAO = new DeveloperDAO();
    }

    public void addCategory(Category category) throws SQLException {
        categoryDAO.addCategory(category);
    }

    public List<Category> getAllCategories() throws SQLException {
        return categoryDAO.getAllCategories();
    }

    public void updateCategory(Category category) throws SQLException {
        categoryDAO.updateCategory(category);
    }

    public void deleteCategory(int categoryId) throws SQLException {
        categoryDAO.deleteCategory(categoryId);
    }

    public void addDeveloper(Developer developer) throws SQLException {
        developerDAO.addDeveloper(developer);
    }
    
    public List<Developer> getAllDevelopers() throws SQLException {
        return developerDAO.getAllDevelopers();
    }

    public void updateDeveloper(Developer developer) throws SQLException {
        developerDAO.updateDeveloper(developer);
    }

    public void deleteDeveloper(int developerId) throws SQLException {
        developerDAO.deleteDeveloper(developerId);
    }

    public void addBug(Bug bug) throws SQLException {
        bugDAO.addBug(bug);
    }

    public List<Bug> getAllBugs() throws SQLException {
        return bugDAO.getAllBugs();
    }

    public void updateBug(Bug bug) throws SQLException {
        bugDAO.updateBug(bug);
    }

    public void deleteBug(int bugId) throws SQLException {
        bugDAO.deleteBug(bugId);
    }
    
    public List<Bug> getBugsAssignedToDeveloper(String developerName) throws SQLException {
        return bugDAO.getBugsAssignedToDeveloper(developerName);
    }

    public List<Bug> getAllBugsWithCategoryNames() throws SQLException {
        return bugDAO.getAllBugsWithCategoryNames();
    }

    public List<String> getBugCountsByDeveloper() throws SQLException {
        return bugDAO.getBugCountsByDeveloper();
    }

    public List<String> getBugsWithDeveloperDetails() throws SQLException {
        return bugDAO.getBugsWithDeveloperDetails();
    }

    public List<Bug> getBugsResolvedInTimeFrame(Timestamp startTime, Timestamp endTime) throws SQLException {
        return bugDAO.getBugsResolvedInTimeFrame(startTime, endTime);
    }

    public List<Developer> getDevelopersWithMostBugsAssigned() throws SQLException {
        return bugDAO.getDevelopersWithMostBugsAssigned();
    }

    public List<Bug> getBugsByCategoryName(String categoryName) throws SQLException {
        return bugDAO.getBugsByCategoryName(categoryName);
    }

    public int getMaxBugsAssignedToDeveloper() throws SQLException {
        return bugDAO.getMaxBugsAssignedToDeveloper();
    }

    public List<Developer> getDevelopersWithResolvedBugsAboveThreshold(int threshold) throws SQLException {
        return bugDAO.getDevelopersWithResolvedBugsAboveThreshold(threshold);
    }

}
