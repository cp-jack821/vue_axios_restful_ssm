$(function(){

//    v
    var model = {

        // user:{},
        code:"",
        username:"",
        password:"",
        code1:""

    };

    // vm
    var vm = new Vue({
        el: "#login_div",
        data: model,
        methods: {
            loginUser:function (){
                console.log("aaa")
                axios.
                request({
                    url:"/uc/lu",
                    method:"post",
                    data:{
                        username:this.username,
                        password:this.password,
                        code:this.code
                    }
                }).
                then((resData)=>{
                    console.log(resData.data)
                    if(resData.data == "OK") {
                        location.href = "../page/user.html";
                    }
                    if(resData.data == "用户名错误或不存在该用户"){
                        alert("用户名输入有误");
                    }
                    if(resData.data == "ERR"){
                        alert("密码错误");
                    }
                    if(resData.data == "验证码错误"){
                        alert("验证码错误");
                    }
                }).catch((err)=>{
                    console.log(err);
                })
            },
            selectCode:function (){
                axios.
                get("/uc/sc",{params:{

                    }}).
                then((resData)=>{
                    console.log(resData.data);
                    this.code1 = resData.data;
                }).
                catch((err)=>{
                    console.log(err);
                })
            }
        },
        computed: {

        },
        watch: {

        },
        created: function (){

            this.selectCode();

        }
    });
});