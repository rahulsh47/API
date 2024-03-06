import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSuite {
    POST post;
    GET get;
    UPDATE update;
    DELETE delete;
    @BeforeTest
    void Setup(){
         post = new POST();
         get = new GET();
         update = new UPDATE();
         delete = new DELETE();
    }
    @Test(priority = 1  , description = "Verify that the User should be created with Valid Name and Email")
    void CreateUser_1(){
        Assert.assertEquals(post.createUserTest(RandomGenerator.generateRandomName(),RandomGenerator.generateRandomEmail(),"male","active"),201);
    }

    @Test(priority = 2 , description = "Verify that the user should not be created with Email as Null")
    void CreateUser_2(){
        Assert.assertEquals(POST.InvalidRequest(RandomGenerator.generateRandomName(), null,"male" , "active"),422);
    }

    @Test(priority = 3 , description = " Verify that the user should not be  created using Name as Null")
    public void CreateUser_3(){
        Assert.assertEquals(POST.InvalidRequest(null,RandomGenerator.generateRandomEmail(),"male","active"),422);
    }
    @Test(priority = 4 , description = "Verify that the User should not be Created with Gender as Null")
    public void CreateUser_4(){
        Assert.assertEquals(POST.InvalidRequest(RandomGenerator.generateRandomName(),RandomGenerator.generateRandomEmail(),null,"Active"),422);
    }
    @Test(priority = 5 , description = "Verify that User should not be created with status as Null")
    public void CreateUser_5(){
        Assert.assertEquals(POST.InvalidRequest(RandomGenerator.generateRandomName(),RandomGenerator.generateRandomEmail(),"male",null),422);
    }
    @Test(priority = 6 ,description = "Verify that the user should not be created with the existing Email")
    public void CreateUser_6(){
        Assert.assertEquals(post.createUserTest(RandomGenerator.generateRandomName(),"rahul236@gmail.com","male","active"),422);
    }
    @Test(priority = 7 ,description = "Verify that the user should not be created from Invalid Email format")
    public void CreateUSer_7(){
        Assert.assertEquals(post.createUserTest(RandomGenerator.generateRandomName(),"rahul236gmail.com","male","active"),422);
    }






}
