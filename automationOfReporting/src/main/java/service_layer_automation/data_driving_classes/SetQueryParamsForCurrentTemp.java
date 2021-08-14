package service_layer_automation.data_driving_classes;

public class SetQueryParamsForCurrentTemp {

    private final String q;
    private final String appid;

    private SetQueryParamsForCurrentTemp(QueryParamBuilder builder){
        this.q=builder.q;
        this.appid=builder.appid;
    }

    public String getQ(){
        return q;
    }

    public String getAppid(){
        return appid;
    }

    public static class QueryParamBuilder{
        private String q;
        private String appid;

        public QueryParamBuilder q(String q){
            this.q=q;
            return this;
        }

        public QueryParamBuilder appid(String apid){
            this.appid=apid;
            return this;
        }

        public SetQueryParamsForCurrentTemp build(){
            return new SetQueryParamsForCurrentTemp(this);
        }

    }

}
