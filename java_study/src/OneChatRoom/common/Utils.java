package OneChatRoom.common;

import static OneChatRoom.common.Constants.*;

/**
 * 信息检查类
 */
public class Utils {
    /**
     * 用户名检查
     * @param userName 一个用户名字符串
     * @return 空
     */
    public static String isValidUserName(String userName){
        String ret = isValidToUserName(userName);
        // 判断用户名不为空
        if(ret != null){
            return ret;
        }
        // 不能包含 admin
        if (userName.toLowerCase().contains(ADMIN_NAME)){
            return "用户名不可以包含" + ADMIN_NAME;
        }
        return null;
    }

    /**
     * 用户名特殊字符合法检查
     * @param userName 用户名
     * @return 空
     */
    public static String isValidToUserName(String userName) {
        if(userName.trim().length() == 0){
            return "用户名不可以为空！";
        }
        if(userName.contains(MESSAGE_SEP_STR)){
            return "用户名不可以包含分隔符！";
        }
        // 不能包含@
        if (userName.contains(CHAT_WITH_START)){
            return "用户名不可以包含" + CHAT_WITH_START;
        }
        // 不能包含"anonymous"
        if (userName.toLowerCase().contains(NO_NAME)){
            return "用户名不可以包含" + NO_NAME;
        }
        if (userName.contains(SPACE_STRING)){
            return "用户名不可以包含空格！";
        }
        return null;
    }

    /**
     *
     * @param userName 一个用户名字符串
     * @return 用户名（去空格）
     */
    public static String getNormalizedUserName(String userName){
        return userName.trim();
    }
}
