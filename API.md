# 消毒餐具配送管理系统

## tips

- code :
  - 0 : 一切正常
  - 1 : 添加 message 字段展示错误
  - 2 : 登陆失败

- url : host + uri
  - example :
    - host : <http://sanlao.net>
    - uri : /login
    - url : <http://sanlao.net/login>

## 产品相关

### 获取产品信息

- GET /product/{id}

- return :

```json
{
    "code" : 0,
    "data" :
        [
            {
                "id" : 1,
                "name" : "筷子",
                "count" : 1000
            },
            {
                "id" : 2,
                "name" : "碗",
                "count" : 800
            }
        ]
}
```

---

### 增加产品

- POST /product

```json
{
    "name" : "叉子",
    "count" : 1000
}
```
- return :

```json
{
    "code" : 0,
    "data" : 3
}
```

---

### 删除产品

- DELETE /product/{id}

- return :

```json
{
    "code" : 0,
    "data" : true
}
```

---

### 修改产品

- PUT /product
- payload :

```json
{
    "id" : 1,
    "name" : "筷子",
    "count" : 1000
}
```

- return :

```json
{
    "code" : 0,
    "data" : true
}
```

---

## 车辆信息

### 查询车辆

- GET /car/{id}

- return :
    - status ： 0 可使用 1 配送中

```json
{
    "code" : 0,
    "data" :
        [
            {
                "id" : 1,
                "name" : "运输车A",
                "number" : "黑A1231",
                "status" : 0
            },
            {
                "id" : 2,
                "name" : "运输车B",
                "number" : "黑A1232",
                "status" : 1
            }
        ]
}
```

---

### 增加车辆

- POST /car

```json
{
    "name" : "运输车A",
    "number" : "黑A1231"
}
```
- return :

```json
{
    "code" : 0,
    "data" : 3
}
```

---

### 删除汽车

- DELETE /car/{id}

- return :

```json
{
    "code" : 0,
    "data" : true
}
```

---

### 修改汽车

- PUT /car

```json
{
    "id" : 1,
    "name" : "运输车A",
    "number" : "黑A1231",
    "status" : 0
}
```

- return :

```json
{
    "code" : 0,
    "data" : true
}
```

---

## 员工信息

### 查询员工

- GET /employee/{id}

- return :

```json
{
    "code" : 0,
    "data" :
        [
            {
                "id" : 1,
                "name" : "张三",
                "sex" : "男",
                "position" : "经理",
                "comment" : ""
            },
            {
                "id" : 2,
                "name" : "李四",
                "sex" : "男",
                "position" : "副经理",
                "comment" : ""
            }
        ]
}
```

---

### 增加员工

- POST /employee

```json
{
    "name" : "王五",
    "sex" : "男",
    "position" : "配送员",
    "comment" : ""
}
```
- return :

```json
{
    "code" : 0,
    "data" : 3
}
```

---

### 删除员工

- DELETE /employee/{id}

- return :

```json
{
    "code" : 0,
    "data" : true
}
```

---

### 修改员工

- PUT /employee

```json
{
    "id" : 1,
    "name" : "王五",
    "sex" : "男",
    "position" : "配送员",
    "comment" : ""
}
```

- return :

```json
{
    "code" : 0,
    "data" : true
}
```

---

## 客户信息

### 查询客户

- GET /client/{id}

- return :

```json
{
    "code" : 0,
    "data" :
        [
            {
                "id" : 1,
                "name" : "张三"
            },
            {
                "id" : 2,
                "name" : "李四"
            }
        ]
}
```

---

### 增加客户

- POST /client

```json
{
    "name" : "王五",
}
```
- return :

```json
{
    "code" : 0,
    "data" : 3
}
```

---

### 删除客户

- DELETE /client/{id}

- return :

```json
{
    "code" : 0,
    "data" : true
}
```

---

### 修改客户

- PUT /client

```json
{
    "id" : 1,
    "name" : "王五"
}
```

- return :

```json
{
    "code" : 0,
    "data" : true
}
```

---

## 配送管理

### 配送查询

- GET /delivery/{id}

- return :

```json
{
    "code" : 0,
    "data" :
        [
            {
                "id" : 1,
                "client" : "东北林业大学",
                "thing" : [
                    {
                    "id" : 1,
                    "name" : "筷子",
                    "count" : 100
                    },
                    {
                    "id" : 2,
                    "name" : "杯子",
                    "count" : 200
                    }
                ],
                "start" : "2019-10-10",
                "end" : "2019-10-11",
                "status" : 0,
                "car" : "运输车A",
                "employee" : "张三"
            },
            {
                "id" : 2,
                "client" : "东北林业大学",
                "thing" : [
                    {
                    "name" : "筷子",
                    "count" : 100
                    },
                    {
                    "name" : "杯子",
                    "count" : 200
                    }
                ],
                "start" : "2019-10-10",
                "end" : "2019-10-11",
                "status" : 0,
                "car" : "运输车A",
                "employee" : "张三"
            }
        ]
}
```

---

### 增加配送

- POST /delivery

```json
 {
    "id" : 1,
    "client" : "东北林业大学",
    "thing" : [
        {
        "id" : 1,
        "name" : "筷子",
        "count" : 100
        },
        {
        "id" : 2,
        "name" : "杯子",
        "count" : 200
        }
    ],
    "start" : "2019-10-10",
    "end" : "2019-10-11"
}
```

- return :

```json
{
    "code" : 0,
    "data" : 3
}
```

---

### 修改配送

- PUT /delivery

```json
{
    "id" : 2,
    "client" : "东北林业大学",
    "thing" : [
        {
        "name" : "筷子",
        "count" : 100
        },
        {
        "name" : "杯子",
        "count" : 200
        }
    ],
    "start" : "2019-10-10",
    "end" : "2019-10-11",
    "status" : 0,
    "car" : "运输车A",
    "employee" : "张三"
}
```

- return :

```json
{
    "code" : 0,
    "data" : true
}
```

### 删除配送

- DELETE /delivery/{id}

- return :

```json
{
    "code" : 0,
    "data" : true
}
```

---

## 财务管理

### 查询财务

- GET　/finance/{id}

- return :

```json
{
    "code" : 0,
    "data" :
        [
            {
                "id" : 1,
                "total" : 1000,
                "current" : 800
            },
            {
                "id" : 2,
                "total" : 1000,
                "current" : 800
            }
        ]
}
```

### 登记财务

- PUT /finance

```json
{
    "id" : 1,
    "total" : 1000,
    "current" : 800
}
```

- return :

```json
{
    "code" : 0,
    "data" : true
}
```

---

### 统计

- GET /stats

- retuen :

```json
{
    "total" : 1000,
    "current" : 100,
    "need" : 900
}
```