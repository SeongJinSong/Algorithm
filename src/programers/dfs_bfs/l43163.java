package programers.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import programers.dfs_bfs.l43163.Word;

public class l43163 {
	public static void main(String[] args) {
		String begin="hit",target="cog"; String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};
//		String begin="hit",target="cog"; String[] words= {"hot", "dot", "dog", "lot", "log"};
		System.out.println(new l43163().solution(begin, target, words));
	}
	class Word{
		private String word;
		private Integer depth;
		public Word(String word, Integer depth) {
			this.word=word;
			this.depth=depth;
		}
	}
	/*contain 함수로 bfs전에 체크를 하고 싶어서 ArrayList를 사용했다.*/
	public int solution(String begin, String target, String[] words) {
		ArrayList<String> arr = new ArrayList<String>(Arrays.asList(words));
		HashSet<String> hs = new HashSet<String>();
		if(!arr.contains(target))return 0;
		Queue<Word> q = new LinkedList<Word>();
		q.add(new Word(begin, 0));
		while(!q.isEmpty()) {
			Word cur = q.poll();
			if(target.equals(cur.word))return cur.depth;
			hs.add(cur.word);
			for(String s : arr) {
				if(hs.contains(s)||!check1diff(cur.word, s))continue;
				q.add(new Word(s, cur.depth+1));
			}
		}
        int answer = 0;
        return answer;
    }
	public boolean check1diff(String a, String b) {
		int diff=0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)!=b.charAt(i))diff++;
		}
		if(diff==1)return true;
		return false;
	}
	/*변수짓기 애매했는데 Node라는 추상적인 변수가 더 자연스럽다.*/
	class Node{
		private String word;
		private Integer depth;
		public Node(String word, Integer depth) {
			this.word=word;
			this.depth=depth;
		}
	}
	public int solution2(String begin, String target, String[] words) {
		/*visit 이라는 변수가 더 적합하다.*/
		boolean[] visit = new boolean[words.length];
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(begin, 0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(target.equals(cur.word))return cur.depth;
			for(int i=0;i<words.length;i++) {
				if(visit[i]||!check1diff(cur.word, words[i]))continue;
				q.add(new Node(words[i], cur.depth+1));
				visit[i]=true;
			}
		}
        return 0;
    }
	/*isNext라는 추상적인 함수명이 더 나을 것 같다.*/
	public boolean isNext(String a, String b) {
		int diff=0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)!=b.charAt(i)) {
				if(diff++>1)return false;
			}
		}
		return true;
	}
	
	/* Stream을 극한으로 활용한 사례인것 같아서 가져왔다*/
	public int solution3(String begin, String target, String[] words) {
        return Arrays.stream(words)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Words::from))
                .calculateMinConversionCount(begin, target);
    }

    private static class Words {
        private final List<Word2> words;
        private final Map<Word2, Boolean> usedWords;

        public Words(List<Word2> words) {
            this.words = words;
            this.usedWords = words.stream()
                    .collect(Collectors.toMap(Function.identity(), word -> Boolean.FALSE));
        }

        public static Words from(List<String> words) {
            List<Word2> words1 = words.stream()
                    .map(Word2::new)
                    .collect(Collectors.toList());

            return new Words(words1);
        }

        public Integer calculateMinConversionCount(String begin, String target) {
        	Word2 word = new Word2(begin);
        	Word2 targetWord = new Word2(target);

            MinCount minCount = new MinCount();
            calculateMinConversionCount(word, targetWord, 0, minCount);

            if (minCount.isDefaultCount()) {
                return 0;
            }

            return minCount.getCount();
        }

        private void calculateMinConversionCount(Word2 word, Word2 targetWord, Integer count, MinCount minCount) {
            if (word.equals(targetWord)) {
                minCount.updateMin(count);
            }

            List<Word2> nextWords = getNextWords(word);

            if (nextWords.isEmpty() || minCount.isLessEqualsThan(count)) {
                return;
            }

            for (Word2 from : nextWords) {
                this.usedWords.put(from, Boolean.TRUE);
                calculateMinConversionCount(from, targetWord, count + 1, minCount);
                this.usedWords.put(from, Boolean.FALSE);
            }
        }

        private List<Word2> getNextWords(Word2 from) {
            return this.words.stream()
                    .filter(to -> this.isConvertible(from, to))
                    .collect(Collectors.toList());
        }

        private boolean isConvertible(Word2 from, Word2 to) {
            return !this.usedWords.get(to) && from.isConvertibleTo(to);
        }
    }

    private static class Word2 {
        private final String word;

        public Word2(String word) {
            this.word = word;
        }

        public boolean isConvertibleTo(Word2 word) {
            return IntStream.range(0, this.word.length())
                    .filter(index -> this.word.charAt(index) != word.word.charAt(index))
                    .count() == 1L;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word1 = (Word) o;
            return Objects.equals(word, word1.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word);
        }
    }

    private static class MinCount {
        private static final Integer DEFAULT_COUNT = Integer.MAX_VALUE;
        private Integer count;

        public MinCount() {
            this.count = DEFAULT_COUNT;
        }

        public void updateMin(Integer count) {
            this.count = Integer.min(this.count, count);
        }

        public Integer getCount() {
            return count;
        }

        public boolean isDefaultCount() {
            return DEFAULT_COUNT.equals(this.count);
        }

        public boolean isLessEqualsThan(Integer count) {
            return this.count <= count;
        }
    }
}
