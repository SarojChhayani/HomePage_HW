package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NewsReleasePage extends Utils {
    private By _title = By.id("AddNewComment_CommentTitle");
    private By _comment = By.id("AddNewComment_CommentText");
    private By _newComment = By.name("add-comment");
    private By _actualCommentMsg = By.className("result");
    private By _commentContainer = By.className("comment-list");
    private By _lastComment = By.xpath("//div[@class='comment-list']/div[2]/div[4]");
    public void addingNewComment() {
        //Type Title
        typeText(_title, " Mr. XYZ");
        // Type Comment
        typeText(_comment, "Hello Mr.XYZ");
        //click on NEW COMMENT
        clickOnElement(_newComment);
        //actual test msg after click on NEW COMMENT
        String actualMsg = getTextFromElement(_actualCommentMsg);

        //comparing actual and expected
        Assert.assertEquals(actualMsg, loadProp.getProperty("expectedMsg"), "Your Comment Is Not Added.");

        // Locate the container or element that holds all the comments
        WebElement commentsContainer = driver.findElement(_commentContainer);
        // Find the last comment element within the container
        WebElement lastComment = commentsContainer.findElement(_lastComment);
        //Storing last Comment Text
        String lastCommentText = lastComment.getText();
        // Add a new comment (code to add a new comment goes here)
        //locate the last comment after adding the new comment
        WebElement newLastComment = commentsContainer.findElement(_lastComment);
        //Storing new last comment
        String newLastCommentText = newLastComment.getText();
        // Compare the text or content of the last comment before and after adding the new comment
        if (lastCommentText.equals(newLastCommentText)) {
            System.out.println("New comment is shown at the last position.");
        } else {
            System.out.println("New comment is not shown at the last position.");
        }

    }


}
