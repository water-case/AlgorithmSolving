# 알고리즘 기초코드정리 ⏸

## 순열
```java
// 순열 nPr
static void Permutation(int cnt, boolean[] v, int[] nums) {
  if(cnt == r)
    return;

  for(int i=0; i<n; i++){
    if(v[i]) continue;

    nums[cnt]=i;
    v[i]=true;
    Permutation(cnt+1, v, nums);
    v[i]=false;
  }
}
```

## 조합
```java
// 조합 nCr
static void Combination(int cnt, int start, int[] nums){
  if(cnt == r)
    return;

  for(int i=start; i<n; i++){
    nums[cnt]=i;
    Combination(cnt+1, i+1, nums);
  }
}
```

## 부분집합
```java
// 부분집합 n개의 원소로 생성될 수 있는 부분집합
static void Subset(int cnt, boolean[] v){
  if(cnt == n)
    return;

  v[cnt]=true;
  Subset(cnt+1, v);
  v[cnt]=false;
  Subset(cnt+1, v);
}
```

## 스택
```java
static class Node {
  String data;
  Node link;

  public Node(String data, Node link) {
    this.data=data;
    this.link=link;
  }
  public Node(String data){
    this.data=data;
  }
}

static class Stack {
  private Node top;

  public String push(String data){
    top=new Node(data, top);
  }
  
  public String pop() {
    if(isEmpty()) return null;

    Node popNode=top;
    top=popNode.link;
    popNode.link=null;
    
    return popNode.data;
  }

  public boolean isEmpty() {
    return top==null;
  }
}
```

## 큐
```java
static class Node {
  String data;
  Node link;

  public Node(String data, Node link) {
    this.data=data;
    this.link=link;
  }
  public Node(String data){
    this.data=data;
  }
}

static class Queue {
  Node front;
  Node rear;
  int count;

  public void offer(int data) {
    Node newNode=new Node(data);

    if(isEmpty())
      front=newNode;
    else
      rear.link=newNode;

    rear=newNode;
    count++;
  }
  public String pull() {
    if(isEmpty())
      return null;

    String data=front.data;
    front=front.link;
    count--;

    return data;
  }
  public boolean isEmpty() {
    return count==0;
  }
}
```
