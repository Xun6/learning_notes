package OneChatRoom.common;

import java.util.Objects;

import static OneChatRoom.common.Constants.MESSAGE_BREAK;
import static OneChatRoom.common.Constants.MESSAGE_SEP;

/**
 * 聊天消息的描述
 */
public class ChatMessage {
    private String from;
    private String to;
    private String message;

    /**
     * 带参数构造函数
     * @param from 消息发送者
     * @param to 消息接受者
     * @param message 消息内容
     */
    public ChatMessage(String from,String to, String message){
        this.from = from;
        this.to = to;
        this.message = message.trim();
    }

    private ChatMessage(){}

    /**
     * 构建一个消息，分割消息内容
     * @param message 拼接好的字符串消息内容
     * @return 返回当前对象
     */
    public static ChatMessage buildFrom(String message){
        ChatMessage ret = new ChatMessage(); // 实例化当前对象类
        int fromEnd = message.indexOf(MESSAGE_SEP); // 返回在消息字符串中，第一次出现 MESSAGE_SEP 字符的索引值，该字符作为一个分隔符
        ret.from = message.substring(0,fromEnd); //返回截取索引为[0,fromEnd],范围内的字符串
        int toEnd = message.indexOf(MESSAGE_SEP,fromEnd + 1); // 从索引位置fromEnd + 1开始搜索，返回在消息字符串中，第一次出现 MESSAGE_SEP 字符的索引值
        ret.to = message.substring(fromEnd +1,toEnd); // 返回截取索引为[fromEnd +1,toEnd]，范围内的字符串
        ret.message = message.substring(toEnd + 1).trim(); // 返回从索引toEnd + 1开始往后的所有字符串
        return ret;
    }

    /**
     * 将聊天消息拼接成可以被分割的字符串
     * @return 返回拼接后的字符串
     */
    public String toMessageString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(from).append(MESSAGE_SEP).append(to).append(MESSAGE_SEP).append(message).append(MESSAGE_BREAK);
        return stringBuilder.toString();
    }

//    // 这是一个测试
//    public static void main(String[] args) {
//        ChatMessage chatMessage = new ChatMessage("testfrom","testto","这是一个测试消息，你不知道的消息，很生气的啊嗷嗷");
//        String strMessage = chatMessage.toMessageString().trim(); //拼接消息
//        System.out.println(strMessage);
//        ChatMessage parsed = buildFrom(strMessage); // 利用 MESSAGE_SEP 对消息进行分割
//        System.out.println(parsed);
//        System.out.println(parsed.equals(chatMessage));
//    }

    //======
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatMessage)) return false;
        ChatMessage that = (ChatMessage) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(to, that.to) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from,to,message);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
