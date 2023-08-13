# kubernetes-microservices

<u>Services</u>
1. $Student$
2. $Employee$

<u>Components</u>
1. $Kubernetes$ $cluster$
2. $Helm$
3. $Micro$ $Services$

## Student Service

METHOD | API | DESCRIPTION
---------|----------|---------
 `GET` | $/students$ | Get the students (Hard Coded)
 `GET` | $/employees$ | Get the employees (Hard Coded)

## How to run ##

```Prerequiste: kubernetes, helm```

$step$ $1$ 

```
docker run -d -p 5000:5000 --restart=always --name registry registry:2
```

$step$ $2$

```
docker pull ghcr.io/amankapur007/kbmicro-student:latest
docker pull ghcr.io/amankapur007/kbmicro-employee:latest
```

$step$ $3$

```
docker tag ghcr.io/amankapur007/kbmicro-student:latest localhost:5000/kbmicro-student:latest
docker tag ghcr.io/amankapur007/kbmicro-employee:latest localhost:5000/kbmicro-employee:latest
```

$step$ $4$

```
docker push localhost:5000/kbmicro-student:latest
docker push localhost:5000/kbmicro-employee:latest
```

$step$ $5$

```
helm install {-n <namespace>} <release name> -f kbmicro/values.yaml kbmicro
```
>Sample
```
helm install kbmicro -f kbmicro/values.yaml kbmicro
```
```Note: Any commands inside curly {} are optional, replace anything inside <> with name [any value can be given] ```

$step$ $6$

```
kubectl get pods {-n <namespace>} or kubectl get svc {-n <namespace>}
```
>Sample
```
kubectl get pods
```
