# Java Spring Template to HenriqueTest Application

To test `henrique` application, execute the follow commands:
```
kubectl -n hsulimann port-forward svc/henrique 8086:8086

curl -vs http://localhost:8086/init
```

The result need be the same like this:
```
Get realizado com sucesso!
```
