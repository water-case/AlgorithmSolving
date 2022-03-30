# 알고리즘 기초코드정리 ⏸

## 목차
  - [순열](#순열)
  - [조합](#조합)
  - [부분집합](#부분집합)
  - [스택](#스택)
  - [큐](#큐)
  - [dfs (깊이우선탐색)](#dfs-깊이우선탐색)
  - [bfs (너비우선탐색)](#bfs-너비우선탐색)
  - [Dijkstra](#dijkstra)
  - [UnionFind](#unionfind)
  - [Kruskal](#kruskal)
  - [Prim](#prim)
  - [KMP](#kmp)
  - [](#)

## 순열
```java
// 순열 nPr
static void Permutation(int cnt, boolean[] v, int[] nums) {
  if(cnt == r)
    return;

  for(int i=0; i<n; i++) {
    if(v[i]) continue;

    nums[cnt]=i;
    v[i]=true;
    Permutation(cnt+1, v, nums);
    v[i]=false;
  }
}
```
[목차로 이동](#목차)

## 조합
```java
// 조합 nCr
static void Combination(int cnt, int start, int[] nums) {
  if(cnt == r)
    return;

  for(int i=start; i<n; i++) {
    nums[cnt]=i;
    Combination(cnt+1, i+1, nums);
  }
}
```
[목차로 이동](#목차)

## 부분집합
```java
// 부분집합 n개의 원소로 생성될 수 있는 부분집합
static void Subset(int cnt, boolean[] v) {
  if(cnt == n)
    return;

  v[cnt]=true;
  Subset(cnt+1, v);
  v[cnt]=false;
  Subset(cnt+1, v);
}
```
[목차로 이동](#목차)

## 스택
```java
static class Node {
  String data;
  Node link;

  public Node(String data, Node link) {
    this.data=data;
    this.link=link;
  }
  public Node(String data) {
    this.data=data;
  }
}

static class Stack {
  private Node top;

  public String push(String data) {
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
[목차로 이동](#목차)

## 큐
```java
static class Node {
  String data;
  Node link;

  public Node(String data, Node link) {
    this.data=data;
    this.link=link;
  }
  public Node(String data) {
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
  public String poll() {
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
[목차로 이동](#목차)

## DFS (깊이우선탐색)
```java
// 배열 4방향 탐색 기준 DFS
static int N=5;
static int[] delx={-1, 0, 1, 0}; // 상우하좌
static int[] dely={ 0, 1, 0,-1};
static boolean[][] v;

static void dfs(int x, int y) {
  v[x][y]=true;
  for(int d=0; d<4; d++) {
    int dx=x+delx[d];
    int dy=y+dely[d];
    if(dx<0 || dx>=4 || dy<0 || dy>=4) continue;
    dfs(dx, dy);
  }
}
```
[목차로 이동](#목차)

## BFS (너비우선탐색)
```java
// 배열 4방향 탐색 기준 BFS
static int N=5;
static int[] delx={-1, 0, 1, 0}; // 상우하좌
static int[] dely={ 0, 1, 0,-1};
static boolean[][] v;

static void bfs(int x, int y) {
  Queue<int[]> q=new LinkedList<>();
  v[x][y]=true;
  q.offer(new int[] {x, y});
  
  while(!q.isEmpty()) {
    int[] now=q.poll();
    x=now[0]; y=now[1];

    for(int d=0; d<4; d++) {
      int dx=x+delx[d];
      int dy=y+dely[d];
      if(dx<0 || dx>=4 || dy<0 || dy>=4) continue;
      v[dx][dy]=true;
      q.offer(new int[] {dx, dy});
    }
  }
}
```
[목차로 이동](#목차)

## Dijkstra
```java
static class Node implements Comparable<Node> {
  int end, price;

  public Node(int end, int price) {
    this.end=end;
    this.price=price;
  }
  @Override
  public int compareTo(Node o) {
    return price-o.price;
  }
}

public static void main(String[] args) throws Exception {
  int n; // 정점수
  int d; // 간선수
  ArrayList<Node>[] g; // 간선 그래프 배열
  boolean[] v; // 정점 방문 배열
  int[] dist; // 각 정점까지의 최단거리
  
  PriorityQueue<Node> pq=new PriorityQueue<>();
  dist[0]=0;
  pq.add(new Node(0, 0));
  
  while(!pq.isEmpty()) {
    Node now=pq.poll();
    
    if(v[now.end]) continue;
    v[now.end]=true;
    
    for(Node next:g[now.end])
      if(!v[next.end] && dist[next.end] > dist[now.end]+next.price){
        dist[next.end] = dist[now.end]+next.price;
        pq.add(new Node(next.end, dist[next.end]));
      }
  }
}
```
[목차로 이동](#목차)

## UnionFind
``` java
static int N;
static int[] parent;

public static void makeSet() {
  parent=new int[N];
  for(int i=0; i<N; i++) parent[i]=i;
}

public static int find(int a) {
  if(a==parent[a]) return a;
  return parent[a]=find(parent[a]);
}

public static boolean union(int a, int b) {
  a=find(a);
  b=find(b);
  if(find(a)==find(b)) return true;
  parent[b]=a;
  return false;
}
```
[목차로 이동](#목차)

## Kruskal
``` java
static class Edge implements Comparable<Edge> {
  int start, end, price;

  public Edge(int start, int end, int price) {
    this.start=start;
    this.end=end;
    this.price=price;
  }

  @Override
  public int compareTo(Edge o) {
    return Integer.compare(price, o.price);
  }
}

public static void main(String[] args) {
  int[] parent;
  ArrayList<Edge> edgeList;

  Collections.sort(edgeList);
  makeSet();

  int result=0, cnt=0;
  for(Edge e:edgeList)
    if(union(e.start, e.end)) {
      result+=e.price;
      if(++cnt==N-1) break;
    }
  System.out.println(result);
}
```
[목차로 이동](#목차)

## Prim
```java
public static void main(String[] args) {
  boolean[] v;
  int N;
  int[] mdist;
  int[][] g;

  for(int i=0; i<N; i++) mdist[i]=Integer.MAX_VALUE;
  int result=0;
  mdist[0]=0;

  for(int c=0; c<N; c++) {
    int min=Integer.MAX_VALUE;
    int minV=0;

    for(int i=0; i<N; i++)
      if(!v[i] && min>mdist[i]) {
        min=mdist[i];
        minV=i;
      }

    v[minV]=true;
    result+=min;

    for(int i=0; i<N; i++)
      if(!v[i] && g[minV][i]!=0 && mdist[i]>g[minV][i])
        mdist[i]=g[minV][i];
  }
  System.out.println(result);
}
```
[목차로 이동](#목차)

## KMP
```java
char[] text;
char[] pattern;

int tl=text.length, pl=pattern.length;

int[] pi=new int[pl];
for(int i=0, j=0; i<pl; i++) {
  while(j>0 && pattern[i]!=pattern[j]) j=pi[j-1];
  
  if(pattern[i]==pattern[j]) pi[i]=++j;
  else pi[i]=0;
}

int cnt=0;
for(int i=0,j=0; i<tl; ++i) {
  while(j>0 && text[i]!=pattern[j]) j=pi[j-1];

  if(text[i]==pattern[j]) {
    if(j==pl-1) {
      cnt++;
      j=pi[j];
    } else {
      j++;
    }
  }
}
System.out.println(cnt);
```
[목차로 이동](#목차)

##