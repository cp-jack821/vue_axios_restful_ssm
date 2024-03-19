$(function(){

    //m
    var model = {

        //每页数据条数
        pageSize:"5",
        //页码
        pageNum:"1",
        //
        dept:[],
    //总页数
        pages:0,
    };


//    vm
    var vm = new Vue({

        el:"#panel",
        data:model,
        methods:{

        //    页面载入后查询部门数据+模糊查询
            selectDeptByPage:function (){
                axios.
                get("/tdc/sd", {params: {

                            pageSize: this.pageSize,
                            pageNum: this.pageNum,

                            }
                    }).
                    then((resData)=>{
                        console.log(resData.data);
                        this.dept = resData.data.list;
                        this.pages = resData.data.pages;
                    }).
                    catch((err)=>{
                        console.log(err);
                    });
            },



        },
        computed:{

        },
        watch:{

        },
        created:function(){

            this.selectDeptByPage();

        }
    });

});