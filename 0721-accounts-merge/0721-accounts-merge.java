class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            for(int j=1;j<accounts.get(i).size();j++) {
                String mail=accounts.get(i).get(j);
                if(!map.containsKey(mail)) map.put(mail,i);
                else ds.unionByRank(i,map.get(mail));
            }
        }
        List<String>[] mergedMail=new ArrayList[n];
        for(int i=0;i<n;i++) mergedMail[i]=new ArrayList<>();
        for(Map.Entry<String,Integer> it:map.entrySet()) {
            String mail=it.getKey();
            int node=ds.findUltimateParent(it.getValue());
            mergedMail[node].add(mail);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(mergedMail[i].size()==0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it:mergedMail[i]) temp.add(it);
            ans.add(temp);
        }
        return ans;
    }
}

class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUltimateParent(int node){
        if(node==parent.get(node)) return node;
        int upar=findUltimateParent(parent.get(node));
        parent.set(node,upar);
        return parent.get(node);
    }

    public void unionByRank(int u,int v){
        int ulp_u=findUltimateParent(u);
        int ulp_v=findUltimateParent(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_u)<rank.get(ulp_v)) parent.set(ulp_u,ulp_v);
        else if(rank.get(ulp_v)<rank.get(ulp_u)) parent.set(ulp_v,ulp_u);
        else{
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u,rank.get(ulp_u)+1);
        }
    }
}