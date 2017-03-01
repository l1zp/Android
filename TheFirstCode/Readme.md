郭霖《第一行代码》上例子代码

2.4.4 运行时，提示
```
You need to use a Theme.AppCompat theme (or descendant) with this activity

```
将DialogActivity中
```
public class DialogActivity extends AppCompatActivity
```
改为
```
public class DialogActivity extends Activity
```