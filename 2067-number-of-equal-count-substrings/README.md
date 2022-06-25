<h2><a href="https://leetcode.com/problems/number-of-equal-count-substrings/">2067. Number of Equal Count Substrings</a></h2><h3>Medium</h3><hr><div><p>You are given a <strong>0-indexed</strong> string <code>s</code> consisting of only lowercase English letters, and an integer <code>count</code>. A <strong>substring</strong> of <code>s</code> is said to be an <strong>equal count substring</strong> if, for each <strong>unique</strong> letter in the substring, it appears exactly <code>count</code> times in the substring.</p>

<p>Return <em>the number of <strong>equal count substrings</strong> in </em><code>s</code>.</p>

<p>A <strong>substring</strong> is a contiguous non-empty sequence of characters within a string.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> s = "aaabcbbcc", count = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong>
The substring that starts at index 0 and ends at index 2 is "aaa".
The letter 'a' in the substring appears exactly 3 times.
The substring that starts at index 3 and ends at index 8 is "bcbbcc".
The letters 'b' and 'c' in the substring appear exactly 3 times.
The substring that starts at index 0 and ends at index 8 is "aaabcbbcc".
The letters 'a', 'b', and 'c' in the substring appear exactly 3 times.
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> s = "abcd", count = 2
<strong>Output:</strong> 0
<strong>Explanation:</strong>
The number of times each letter appears in s is less than count.
Therefore, no substrings in s are equal count substrings, so return 0.
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> s = "a", count = 5
<strong>Output:</strong> 0
<strong>Explanation:</strong>
The number of times each letter appears in s is less than count.
Therefore, no substrings in s are equal count substrings, so return 0</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= count &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
</ul>
</div>