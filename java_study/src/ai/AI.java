package ai;

public class AI {
    //回答
    public String answer(String question){
        String ret = null;
        ret = handleCanStart(question);
        if(ret != null){
            return ret;
        }

        ret = handleAskTail(question);
        if(ret != null){
            return ret;
        }

        return handleUnknow(question);

    }

    //匹配开头
    private String handleCanStart(String question){
        //处理逻辑
        String[] canStart = new String[]{"会","能","有","敢","在"};
        for(int i = 0; i < canStart.length; i++){
            //匹配前缀
            if(question.startsWith(canStart[i])){
                return canStart[i] + "!";
            }
        }
        return null;

    }

    //匹配结尾
    private String handleAskTail(String question){
        //处理逻辑
        String[] askTail = new String[]{"吗","吗？","吗?"};
        for(int i =0; i < askTail.length; i++){
            //匹配后缀
            if(question.endsWith(askTail[i])){
                return question.replace(askTail[i],"!");  //替换
            }
        }
        return null;

    }

    //回答不了
    private String handleUnknow(String question){
        return question + "!";
    }
}
