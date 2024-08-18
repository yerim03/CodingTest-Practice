package dfs_bfs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    //방문 표시 배열
    public static boolean[] visited = new boolean[9];
    //행이 3개인 2차원 인접 리스트 표현 - ArrayList를 중첩해서 2차원 형태로 사용
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();


    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        //현재 노드 방문 처리
        visited[start] = true;

        //큐가 빌때 까지 반복
        while (!q.isEmpty()) {
            //큐에서 하나의 원소를 뽑아서 출력
            int x = q.poll();
            System.out.print(x + " ");

            //해당 원소와 연결된, 아직 방문하지 않은 원소를 큐에 삽입
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);    //x와 연결된 노드
                if (!visited[y]) {
                    q.offer(y); //큐에 삽입
                    visited[y] = true;      //방문 처리
                }
            }
        }
    }


    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);
    }
}
