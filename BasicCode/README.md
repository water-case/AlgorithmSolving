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
  - [MST](#mst)
    - [UnionFind](#unionfind)
    - [Kruskal](#kruskal)
    - [Prim](#prim)
  - [KMP](#kmp)
  - [DP](#dp)
    - [피보나치](#피보나치)
    - [동전선택](#동전선택)
    - [이항계수](#이항계수)
    - [0/1냅색](#01냅색)
    - [LIS (최장증가부분수열)](#lis최장증가부분수열)
    - [FloydWarshall (플로이드와샬)](#floydwarshall-플로이드와샬)
  - [Trie](#trie)
  - [LCA (최소공통조상)](#lca-최소공통조상)
  - [SCC (강한연결요소)](#scc-강한연결요소)
    - [코라사주](#코라사주)
    - [타잔](#타잔)
  - [세그먼트트리](#세그먼트트리)
  - [이분매칭](#이분매칭)



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

## MST
### UnionFind
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

### Kruskal
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

### Prim
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

## DP
### 피보나치
```java
int[] memo;
memo[0]=0;
memo[1]=1;
for(int i=2; i<=n; i++)
  memo[i]=memo[i-1]+memo[i-2];
System.out.println(memo[n]);
```
[목차로 이동](#목차)

### 동전선택
```java
int money;
int[] memo; // 최소동전개수
memo[0]=0;
for(int i=1; i<=money; i++) {
  int min=Integer.MAX_VALUE;
  if(i>=1 && memo[i-1]+1<min) min=memo[i-1]+1;
  if(i>=5 && memo[i-5]+1<min) min=memo[i-5]+1;
  if(i>=8 && memo[i-8]+1<min) min=memo[i-8]+1;
  memo[i]=min;
}
```
[목차로 이동](#목차)

### 이항계수
```java
int n,k; // nCk
int[][] memo;
for(int i=0; i<=n; i++) {
  for(int j=0; j<Math.min(i, k); j++) {
    if(k==0 || j==i) memo[i][j]=1;
    else memo[i][j]=memo[i-1][j-1]+memo[i-1][j];
  }
}
```
[목차로 이동](#목차)

### 0/1냅색
```java
int N; // 물품의 수
int K; // 버틸 수 있는 무게
int[] wa; // 물품의 무게 배열
int[] pa; // 물품의 가치 배열
int[][] memo;

int itemW=0, itemP=0;
for(int item=1; item<=N; item++) {
  itemW=wa[item];
  itemP=pa[item];

  for(int weight=1; weight<=K weight++) {
    if(itemW<=weight)
      memo[item][weight]=Math.max(memo[item-1][weight], itemP+memo[item-1][weight-itemW]);
    else
      memo[item][weight]=memo[item-1][weight];
  }
}
```
[목차로 이동](#목차)

### LIS(최장증가부분수열)
```java
int N; // 수열의 총 길이
int[] nums; // 수 배열
int[] lis; // 최장증가부분수열 메모이제이션

for(int i=0; i<N; i++) {
  lis[i]=1;
  for(int j=0; j<i; j++)
    if(nums[j]<nums[i] && lis[i]<lis[j]+1)
      lis[i]=lis[j]+1;
}
```
[목차로 이동](#목차)

### FloydWarshall (플로이드와샬)
```java
int N; // 정점의 수
int[][] g; // 정점간 그래프 (음, 양)

for(int i=0; i<N; i++) { // 그래프 입력시 연결안된곳은 999_999같은 값으로 세팅
  for(int j=0; j<N; j++) {
    g[i][j]=Integer.parseInt(st.nextToken());
    if(i!=j && g[i][j]==0) g[i][j]=999_999;
  }

for(int k=0; k<N; k++) { // 가운데값
  for(int i=0; i<N; i++) { // 시작값
    if(k==i) continue;
    for(int j=0; j<N; j++) { // 도착값
      if(j==i || j==k) continue;
      if(g[i][j] > g[i][k]+h[k][j]) // i - k - j 순서를 기억하면 쉽다
        g[i][j]=g[i][k]+g[k][j];
    }
  }
}
```
[목차로 이동](#목차)

## Trie
```java
static class TrieNode {
  // 자식 노드 맵
  private Map<Character, TrieNode> child=new HashMap<>();
  // 마지막 글자인가?
  private boolean last;

  // 자식 getter
  Map<Character, TrieNode> getChild() {
    return this.child;
  }
  // 마지막글자여부 getter
  boolean isLast() {
    return this.last;
  }
  // 마지막글자여부 setter
  void setIsLast(boolean isLast) {
    this.last=isLast;
  }
}

static class Trie {
  // 루트노드
  private TrieNode root;
  // 생성자
  Trie() {
    root=new TrieNode();
  }
  // 단어 삽입
  void insert(String word) {
    TrieNode thisNode=this.root;
    for(int i=0; i<word.length(); i++)
      thisNode=thisNode.getChild().computelfAbsent(word.charAt(i). c->new TrieNode());
    thisNode.setIsLast(true);
  }
  // 단어가 트라이에 있는가?
  boolean contain(String word) {
    TrieNode thisNode=this.root;
    for(int i=0; i<word.length(); i++) {
      char c=word.charAt(i);
      TrieNode node=thisNode.getChild().get(c);
      if(node==null) return false;
      thisNode=node;
    }
    return thisNode.isLastChar();
  }
  // 단어 삭제
  void delete(String word) {
    delete(this.root, word, 0);
  }
  private void delete(TrieNode thisNode, String word, int idx) {
    char c=word.charAt(idx);
    
    if(!thisNode.getChild().containsKey(c))
      throw new Error("not exist");

    TrieNode child=thisNode.getChild().get(c);
    idx++;
    if(idx==word.length()) {
      if(!child.isLast())
        throw new Error("not exist");

      // 단어 삭제 처리위한 마지막글자여부 false
      child.setIsLastChar(false);
      // 마지막에 알파벳인데 자식노드가 없으면 노드삭제
      if(child.getChild().isEmpty())
        thisNode.getChild().remove(c);
    } else {
      delete(child, word, idx); // 정상적인 삭제를 위해 선 호출

      // 정상적으로 호출이 진행되어 자식 노드가 없고, 해당노드로 이어지는 단어 없으면 노드삭제
      if(!child.isLast() && child.getChild().isEmpty())
        thisNode.getChild().remove(c);
    }
  }
}
```
[목차로 이동](#목차)

## LCA (최소공통조상)
```java
static ArrayList<Integer>[] tree;
static int[][] parent;
static int[] depth;
static int maxD;

public static void mian(String[] args) throws Exception {
  int N; // 노드의 개수

  int tmp=1;
  maxD=0;
  while(tmp<=N) {
    tmp<<=1;
    maxD++;
  }

  parent=new int[N+1][maxD+1]; // 부모저장배열
  depth=new int[N+1]; // 각 노드의 깊이를 저장할 배열
  
  // 루트노드는 1이라는 가정
  treeBuilder(1,1); // 양방향 그래프를 트리구조로 만들며 부모배열 구함

  for(int i=1; i<maxD; i++) // 희소행렬 만들기
    for(int j=1; j<=N; j++)
      parent[j][i]=parent[parent[j][i-1]][i-1]; // 멱수형태로 올라가며 구함

  int M; // lca 구할 쌍의수
  for(int i=0; i<M; i++) {
    int a, b; // lca 구할 노드의 값
    System.out.Println(LCA(a,b));
  }
}

static int LCA(int a, int b) {
  if(depth[a]<depth[b]) { // 다음 for문에서 높이가 큰 것에서 작은 것을 뺄것이므로
    int tmp=a; // 더 큰 높이를 앞으로 오도록 교환
    a=b; // 어차피 다음 for문 이후 같은 값이 될 것이므로 개의치 말것
    b=tmp;
  }

  for(int i=maxD-1; i>=0 i--) // 2의 멱수 형태로 구해진 희소행렬을 이용하여
    if(Math.pow(2, i)<=depth[a]-depth[b]) // 깊이를 맞추며 부모도 찾는다
      a=parent[a][i];
  
  if(a==b) // 깊이를 맞추자마자 부모가 같으면 그대로 리턴
    return a;

  for(int i=maxD-1; i>=0; i--) // 깊이를 맞춰도 서로 부모가 다르면
    if(parent[a][i]!=parent[b][i]) { // 희소행렬을 이용하여 올라가면서 부모를 맞춰본다
      a=parent[a][i];
      b=parent[b][i];
    }

  // 도출된 부모의 값은 인덱스가 0일때의 값을 기준으로 한다
  return parent[a][0]; // 희소행렬을 처음 도출할 때 0번인덱스부터 멱수형태로 올라가며 구하기때문
}

static void treeBuilder(int now, int d) {
  depth[now]=d; // 현재노드의 깊이 세팅
  for(int next: tree[now]) // 현재 노드와 연결된 노드들 중에
    if(depth[next]==0) { // 부모가 없는 것들만 현재 밑으로 넣는다
      treeBuilder(next, d+1);
      parent[next][0]=now; // 부모 넣기
    }
}

```
[목차로 이동](#목차)

## SCC (강한연결요소)
### 코라사주
> 타잔에 비해 구현이 쉬움
```java
static ArrayList<ArrayList<Integer>> g=new ArrayList<>(); // 정방향그래프
static ArrayList<ArrayList<Integer>> rg=new ArrayList<>(); // 역방향그래프
static ArrayList<ArrayList<Integer>> sccList=new ArrayList<>(); // scc리스트
static Stack<Integer> stack=new Stack<>();
static boolean[] v;
static int sccCnt;

public static void main(String[] args) {
  int V; // 정점 개수
  int E; // 간선 개수
  for(int i=0; i<=V; i++) {
    g.add(new ArrayList<>());
    rg.add(new ArrayList<>());
  }

  for(int i=0; i<E; i++) {
    st=new StringTokenizer(br.readLine()," ");
    int a=Integer.parseInt(st.nextToken());
    int b=Integer.parseInt(st.nextToken());
    g.get(a).add(b); // 정방향과 역방향그래프
    rg.get(b).add(a);
  }

  // scc 첫번째 단계 : 특정노드에서 dfs를 돌며 스택에 넣는다, 낮은번호부터
  v=new boolean[V+1];
  for(int i=1; i<=V; i++)
    if(!v[i]) SCC1(i);

  // scc 두번째 단계 : 스택에서 하나씩 빼면서 dfs를 돌며 방문되는건 scc리스트에 넣는다
  v=new boolean[V+1];
  while(!stack.isEmpty()) {
    int now=stack.pop();
    if(!v[now]) {
      SCC2(now);
      sccCount++;
    }
  }
  // scc 리스트 완성 목적에 맞게 출력
}

static void SCC2(int n) {
  visit[n] = true;
  sccList.get(sccCount).add(n);
  for (int next : rg.get(n))
    if (!visit[next])
      SCC2(next);
}

static void SCC1(int n) {
  visit[n] = true;
  for (int next : g.get(n))
    if (!visit[next])
      SCC1(next);
  stack.push(n);
}


```
[목차로 이동](#목차)

### 타잔
> 코사라주에 비해 구현이 어렵지만 활용도가 높음
```java
static int size, num;
static int[] order;
static boolean[] v;
static Stack<Integer> stack=new Stack<>();
static ArrayList<ArrayList<Integer>> g=new ArrayList<>();
static ArrayList<ArrayList<Integer>> sccList=new ArrayList<>();

public static void main(String[] args) {
  int V; // 정점 개수
  int E; // 간선 개수
  for(int i=0; i<=V; i++)
    g.add(new ArrayList<>());

  for(int i=0; i<E; i++) {
    st=new StringTokenizer(br.readLine()," ");
    int a=Integer.parseInt(st.nextToken());
    int b=Integer.parseInt(st.nextToken());
    g.get(a).add(b);
  }

  order=new int[V+1];
  v=new boolean[V+1];
  num=0;

  for(int i=1; i<=V; i++)
    if(order[i]==0)
      SCC(i);
  // scc 리스트 완성 목적에 맞게 출력
}

static void SCC(int idx) {
  order[idx]=(++num);
  stack.add(idx);
  int root=order[idx];

  for(int tmp : g.get(idx)) {
    if(order[tmp]==0)
      root=Math.min(root, SCC(tmp));
    else if(!v[tmp])
      root=Math.min(root, order[tmp]);
  }

  if(root==order[idx]) {
    ArrayList<Integer> tmpscc=new ArrayList<>();
    while(true) {
      int top=stack.pop();
      tmpscc.add(top);
      v[top]=true;
      if(top==idx) break;
    }
    Collections.sort(tmpscc);
    sccList.add(tmpscc);
  }
}
```
[목차로 이동](#목차)

## 세그먼트트리
```java
// 구체적인 사용예시를 위해 백준_11659_구간합구하기 문제를 약식 기술함
static int[] arr, tree;

public static void main(String[] args) {
  int N; // 수의 개수
  int M; // 합을 구해야 하는 횟수

  arr=new int[N];
  tree=new int[N*4]; 
  /* 
   * N*4 이외에 구체적인 세그먼트트리의 크기를 구하는 방법
   * h(트리의높이)=(int) Math.ceil(Math.log(N)/Math.log(2));
   * size(세그먼트트리의 크기)=(int) Math.pow(2, h+1);
   * tree=new int[size];
   */

  init(0, N-1, 1); // 세그먼트 트리 생성
  for(int i=0; i<M; i++) {
    int start; // 구간시작
    int end; // 구간끝
    treeSum(0,N-1, 1, start-1, end-1); // 구간합리턴
  }
}

static int init(int start, int end, int node) {
  if(start==end) return tree[node]=tree[start];
  int mid=(start+end)/2;
  return tree[node]+=init(start, mid, node*2)+init(mid+1, end, node*2+1);
}

static int treeSum(int start, int end, int node, int left, int right) {
  if(left>end || right<start) return 0;
  if(left<=start && right>=end) return tree[node];
  int mid=(start+end)/2;
  return treeSum(start, mid, node*2, left, right)+treeSum(mid+1, end, node*2+1, left, right);
}
```
[목차로 이동](#목차)

## 이분매칭
```java
// 구체적인 사용예시를 위해 백준_11375_열혈강호 문제를 약식 기술함
static ArrayList<ArrayList<Integer>> g=new ArrayList<>();
static boolean[] v;
static int[] work;

public static void main(String[] args) {
  int N; // 직원의 수
  int M; // 일의 개수

  for(int i=0; i<N; i++) {
    ArrayList<Integer> g2=new ArrayList<>();
    st=new StringTokenizer(br.readLine()," ");
    int n=Integer.parseInt(st.nextToken());
    for(int j=0; j<n; j++)
      g2.add(Integer.parseInt(st.nextToken()));
    g.add(g);
  }

  int cnt=0; // 최대 일의 개수
  work=new int[M+1];
  for(int i=1; i<=N; i++) {
    v=new boolean[M+1];
    if(dfs(i)) cnt++;
  }
}

static boolean dfs(int x) {
  for(int next:g.get(x)){
    if(v[next]) continue;
    v[next]=true;
    if(work[next]==0||dfs(work[next])) {
      work[next]=x;
      return true;
    }
  }
  return false;
}
```
[목차로 이동](#목차)