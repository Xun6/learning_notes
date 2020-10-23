import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

import static io.restassured.RestAssured.given;

/**
 * rest-assured 接口测试框架demo( 示例 )
 */

public class RestAssuredDemo {
    Faker faker = new Faker(Locale.CHINA);
    String contentType = "application/x-www-form-urlencoded;charset=UTF-8";
    String cookieString = "UM_distinctid=174a45fac3b502-06bc3b1fc2afae-316b7004-100200-174a45fac3c615; cookie_token=b60a02d93cb3de8ce01da0658c9b42be438c0d7344224a0e118d6b0f0ea0d87d; CNZZDATA1259614235=2114381737-1600481821-%7C1603418953; PHPSESSID=hu9kbn968ci0t8f6t3npnbjhvn; think_language=zh-CN";
    @Test(threadPoolSize = 1,invocationCount = 1)
    public void test() throws Exception{
        given().log().all()
                .contentType(contentType)
                .cookie(cookieString)
                .param("item_type",1)
                .param("item_name",faker.name().username())
                .param("item_description",faker.address().cityName())
                .param("item_domain","")
                .param("password","")

        .when()
                .post("https://www.showdoc.com.cn/server/index.php?s=/api/item/add")
        .then().log().body();
    }
}
