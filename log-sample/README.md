# LogSample

## 1.运行项目

默认端口为：8080

## 2.可用接口

### 获取日志配置

#### 接口URL

> http://127.0.0.1:8080/log/level

#### 请求方式

> GET

#### Content-Type

> form-data

#### 成功响应示例

```JSON
{
  "code": 200,
  "msg": null,
  "data": [
    {
      "name": "ROOT",
      "configuredLevel": "INFO",
      "effectiveLevel": "INFO"
    }
  ],
  "t": 1659532817939
}
```

### 修改日志打印级别

#### 接口URL

> http://127.0.0.1:8080/log/level

#### 请求方式

> POST

#### Content-Type

> form-data

#### 请求Body参数

| 参数名    | 示例值 | 参数类型 | 是否必填 | 参数描述|
|--------| --- | --- | --- | ---|
|  name  | ROOT | Text | 是 | -|
|  level | ERROR | Text | 是 | -|

#### 成功响应示例

```JSON
{
	"code": 200,
	"msg": null,
	"data": true,
	"t": 1658731245515
}
```

### [获取支持的日志级别列表](http://127.0.0.1:8080/log/level/list)

#### 接口URL

> http://127.0.0.1:8080/log/level/list

#### 请求方式

> POST

#### 成功响应示例

```JSON
{
"code": 200,
"msg": null,
"data": [
"TRACE",
"DEBUG",
"WARN",
"ERROR",
"OFF",
"INFO"
],
"t": 1658731004499
}
```


