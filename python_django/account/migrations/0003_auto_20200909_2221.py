# Generated by Django 2.0.7 on 2020-09-09 14:21

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('account', '0002_auto_20200909_1443'),
    ]

    operations = [
        migrations.RenameField(
            model_name='user',
            old_name='id',
            new_name='user_id',
        ),
    ]