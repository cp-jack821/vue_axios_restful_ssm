$(function () {
//    M
    var model = {
        //    页码
        pageNum: 1,
        //  每页数据条数
        pageSize: 5,
        //  表格显示的数据
        users: [],
        //    总记录条数
        total: 0,
        //   总页数
        pages: 0,
        //    模糊查询的字段
        likeUsername: "",
    //    添加、修改
        user:{}
    };

//    VM
    var vm = new Vue({
        el:"#app",
        data:model,
        methods:{
        //    页面载入后查询分页查询+模糊查询
            getUserByPageOrLike:function(){
                axios.get("/uc/gu", {
                    params: {
                        pageNum: this.pageNum,
                        pageSize: this.pageSize,
                        userName: this.likeUsername
                    }}).
                then((resData) => {
                    console.log(resData.data);
                // 给表格显示的数据的属性赋值
                    this.users = resData.data.list;
                //    总记录条数
                    this.total = resData.data.total;
                //    总页数
                    this.pages = resData.data.pages;
                }).
                catch((err) => {
                    console.log(err);
                });
            },
            //根据页码查询
            getUsersByPageNum: function (pageNum) {
                this.pageNum = pageNum;
                //    调用页面载入后的分页查询
                this.getUserByPageOrLike();
            },
            //    根据每页数据条数查询
            getUsersByPageSize: function () {
                //
                this.getUserByPageOrLike();
            },
            // 根据用户名查询
            getUsersByLike: function () {

                this.getUserByPageOrLike();
            },
            //根据ID删除
            removeUserById:function(uuid){
                axios.
                delete("/uc/ru", {params: {id: uuid}}).
                then((resData)=>{
                    console.log(resData.data);
                    if(resData.data == "OK"){
                        this.getUserByPageOrLike();
                    }else{
                        alert("提示：删除失败!");
                    }
                }).
                catch((err)=>{
                    console.log(err);
                })
            },
        //    添加、修改
            submitUser:function(){
               axios.
               request({
                  url:"/uc/su",
                  method:"post",
                   data:this.user
               }).
               then((resData)=>{
                   console.log(resData.data);
                   if(resData.data) {
                       //    清空对象
                       this.user = {};
                       //    调用页面载入后分页查询
                       this.getUserByPageOrLike();
                   }else{
                       alert("提示：添加失败！");
                   }
               }).
               catch((err)=>{
                   console.log(err);
               })
            },
            // 修改函数
            editUser:function(user){
                this.user = user;
            }
        },
        computed:{

        },
        watch:{

        },
        /**
         * created属性：
         *      属于Vue对象的生命周期钩子【11个】
         *      类似于：JS文件
         */
        created:function(){
            //页面载入后进行分页查询
           this.getUserByPageOrLike();

        }
    });

});