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

- GET /product/{systemId}
   - systemId = 0 返回全部信息
   - systemId = 指定ID 返回指定信息


- return :

```json
{
    "code" : 0,
    "data" :
        [
            {
                "systemId" : 1,
                "name" : "筷子",
                "count" : 1000
            },
            {
                "systemId" : 2,
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

- DELETE /product/{systemId}

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
    "systemId" : 1,
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

- GET /car/{systemId}
   - systemId = 0 返回全部信息
   - systemId = 指定ID 返回指定信息
   
- return :
    - status ： 0 可使用 1 配送中

```json
{
    "code" : 0,
    "data" :
        [
            {
                "systemId" : 1,
                "name" : "运输车A",
                "number" : "黑A1231",
                "status" : 0
            },
            {
                "systemId" : 2,
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

- DELETE /car/{systemId}

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
    "systemId" : 1,
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

- GET /employee/{systemId}
   - systemId = 0 返回全部信息
   - systemId = 指定ID 返回指定信息
   
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

- DELETE /employee/{systemId}

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
    "systemId" : 1,
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

- GET /client/{systemId}
   - systemId = 0 返回全部信息
   - systemId = 指定ID 返回指定信息

- return :

```json
{
    "code" : 0,
    "data" :
        [
            {
                "systemId" : 1,
                "name" : "张三"
            },
            {
                "systemId" : 2,
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
    "name" : "王五"
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

- DELETE /client/{systemId}

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
    "systemId" : 1,
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

- GET /delivery/{systemId}
   - systemId = 0 返回全部信息
   - systemId = 指定ID 返回指定信息

- return :

```json
{
    "code" : 0,
    "data" :
        [
            {
                "systemId" : 1,
                "clientName" : "东北林业大学",
                "things" : [
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
                "carNumber" : "运输车A",
                "eId" : "张三",
                "money" : 100
            },
            {
               "systemId" : 2,
               "clientName" : "东北林业大学",
               "things" : [
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
               "carNumber" : "运输车A",
               "eId" : "张三",
               "money" : 100
            }
        ]
}
```

---

### 增加配送

- POST /delivery

```json
 {
    "clientName" : "东北林业大学",
    "things" : [
        {
        "systemId" : 1,
        "name" : "筷子",
        "count" : 100
        },
        {
        "systemId" : 2,
        "name" : "杯子",
        "count" : 200
        }
    ],
    "start" : "2019-10-10",
    "end" : "2019-10-11",
    "money" : 100
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
    "systemId" : 2,
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
---

### 删除配送

- DELETE /delivery/{systemId}

- return :

```json
{
    "code" : 0,
    "data" : true
}
```

---

### 根据配送员筛选订单

- GET /delivery?eId=XX

- return : 

```json
{
    "code" : 0,
    "data" :
        [
            {
                "systemId" : 1,
                "clientName" : "东北林业大学",
                "things" : [
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
                "carNumber" : "运输车A",
                "eId" : "张三",
                "money" : 100
            },
            {
               "systemId" : 2,
               "clientName" : "东北林业大学",
               "things" : [
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
               "carNumber" : "运输车A",
               "eId" : "张三",
               "money" : 100
            }
        ]
}

```

---

## 财务管理

### 查询财务

- GET　/finance/{systemId}
   - systemId = 0 返回全部信息
   - systemId = 指定ID 返回指定信息

- return :

```json
{
    "code" : 0,
    "data" :
        [
            {
                "systemId" : 1,
                "total" : 1000,
                "current" : 800
            },
            {
                "systemId" : 2,
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
    "systemId" : 1,
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