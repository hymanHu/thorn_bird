from django.db import models

# Create your models here.
class User(models.Model):
    id = models.AutoField(primary_key=True)
    user_name = models.CharField(name = "user_name", max_length = 20, blank = True, null = True)
    email = models.CharField(name = "email", max_length = 20, blank = True, null = True)
    password = models.CharField(max_length = 55, blank = True, null = True)
    create_date = models.DateTimeField(auto_now = True, blank = True, null = True)

    # 将 class 转 dict，方便接口返回数据
    def user_dict(self):
        user_dict = {}
        user_dict["id"] = self.id
        user_dict["userName"] = self.user_name
        user_dict["password"] = self.password
        user_dict["email"] = self.email
        if self.create_date:
            user_dict["createDate"] = self.create_date.strftime("%Y-%m-%d %H:%M:%S")
        return user_dict

    # 指定表名，若不指定，默认生成表名为：app名称_类名，比如 app_account_user
    class Meta:
        db_table = ('account_user')