package OneChatRoom.common;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 相关接口
 */
public interface Constants {

    int SERVER_PORT = 45678;  // 服务端口

    Charset DEFAULT_CHARSET = StandardCharsets.UTF_8; // 输入/输出字符编码

    char MESSAGE_SEP = Character.UNASSIGNED; //作为消息分隔符
    String SPACE_STRING = " "; // 空格符
    String MESSAGE_SEP_STR = String.valueOf(Character.UNASSIGNED);   // 分隔符的字符串表示

    String ADMIN_NAME ="admin"; // 主用户名

    String USER_NAME_PASS = "UserNamePass"; //

    String COMMAND_INTRODUCTION = "欢迎来到聊天室，你可以使用@admin list查看所有在线用户，使用@用户名聊跟某个用户聊天，如果和同一个用户聊天，后续的消息则无需再次输入@，可以使用@admin logoff离开聊天室";  // 介绍信息

    String CHAT_WITH_START = "@";  // 聊天指定命令字符

    String NO_NAME = "anonymous";  // 匿名

    String SERVER_COMMAND_LOGOFF = "logoff";  //命令字符，表示离开

    String SERVER_COMMAND_LIST = "list"; //命令字符，表示查看用户列表

    String BYE = "bye";

    String MESSAGE_BREAK = "\n"; //表示消息传输结束符号
}
