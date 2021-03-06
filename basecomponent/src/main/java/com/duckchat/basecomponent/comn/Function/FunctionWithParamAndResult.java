package com.duckchat.basecomponent.comn.Function;

/**
 * 帮助理解泛型 http://blog.csdn.net/s10461/article/details/53941091
 * @version 1.0
 * @date 2018/1/31
 */

public abstract class FunctionWithParamAndResult<Param,Result> extends Function{


    public FunctionWithParamAndResult(String functionName) {
        super(functionName);
    }
    
    public abstract Result function(Param param);
}
