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