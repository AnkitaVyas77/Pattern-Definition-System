# Pattern-Definition-System
Pattern-Definition-System includes Xtext based Pattern Definition Language and Acceleo based Transformation from Pattern to Java Validation Script. Along with Pattern mining approach using FpGrowth-based data mining in Python and LLM-based and comparison of the outputs as evaluation.
![Transformation Pipeline from model based pattern using PDL -> Java validator code for the pattern](Complete_evaluation_pipeline_process_diagram.jpg)

## Metamodel
Concrete Representation of PDL
![Metamodel](PDL_metamodel_diagram.png)

## Evaluation Results

The Table below summarizes the occurrence and filename-level agreement metrics for the data mining-based, ordered, and LLM-found patterns evaluated in the paper.

<table>
  <thead>
    <tr>
      <th>Pattern</th>
      <th>Method</th>
      <th>Ordering in PDL</th>
      <th>Main Structure</th>
      <th>Files Evaluated</th>
      <th>Matches</th>
      <th>Match %</th>
      <th>Agreement</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>P1</td>
      <td>Data Mining-Based</td>
      <td>Unordered</td>
      <td><code>exists:name</code> &amp; <code>exists:on.push</code> &amp; <code>exists:on.push.branches</code></td>
      <td>29,069</td>
      <td>6,790</td>
      <td>23.36%</td>
      <td>6,788 common; 3 mining-only; 2 Java-only</td>
    </tr>
    <tr>
      <td>P2</td>
      <td>Data Mining-Based</td>
      <td>Unordered</td>
      <td><code>exists:jobs.build.steps.[].run</code> &amp; <code>exists:jobs.build.steps.[].uses</code></td>
      <td>29,069</td>
      <td>6,132</td>
      <td>21.09%</td>
      <td>Exact after merging four PDL variants</td>
    </tr>
    <tr>
      <td>P3</td>
      <td>Data Mining-Based</td>
      <td>Unordered</td>
      <td><code>exists:on.workflow_call</code> &amp; <code>exists:on.workflow_call.inputs</code></td>
      <td>29,069</td>
      <td>7,023</td>
      <td>24.15%</td>
      <td>Exact</td>
    </tr>
    <tr>
      <td>P4</td>
      <td>Data Mining-Based</td>
      <td>Unordered</td>
      <td><code>exists:name</code> &amp; <code>exists:on.pull_request</code> &amp; <code>exists:on.push</code></td>
      <td>29,069</td>
      <td>4,255</td>
      <td>14.63%</td>
      <td>Exact</td>
    </tr>
    <tr>
      <td>P5</td>
      <td>Data Mining-Based</td>
      <td>Unordered</td>
      <td><code>eq:jobs.build.runs-on == ubuntu-latest</code></td>
      <td>29,069</td>
      <td>3,015</td>
      <td>10.37%</td>
      <td>Exact</td>
    </tr>
    <tr>
      <td>P6</td>
      <td>Ordered version of P4</td>
      <td>Ordered</td>
      <td><code>exists:on.push</code> followed by <code>exists:on.pull_request</code></td>
      <td>29,069</td>
      <td>3,532</td>
      <td>12.15%</td>
      <td>Exact with Python reference matcher</td>
    </tr>
    <tr>
      <td>P7</td>
      <td>LLM-based</td>
      <td>Unordered</td>
      <td>
        <pre>name: "value"
on: "value"
jobs:
  job_name:
    runs-on: "value"
    steps:
      - name: "value"
        run: "value"</pre>
      </td>
      <td>1,057</td>
      <td>462</td>
      <td>43.71%</td>
      <td>462 common; 5 Python reference matcher-only</td>
    </tr>
    <tr>
      <td>P8</td>
      <td>LLM-based</td>
      <td>Unordered</td>
      <td>
        <pre>name: "value"
on: "value"
jobs:
  "value":
    runs-on: "value"
    steps:
      - name: "value"
        run: "value"
      - uses: "value"</pre>
      </td>
      <td>806</td>
      <td>227</td>
      <td>28.16%</td>
      <td>Exact with Python reference matcher</td>
    </tr>
    <tr>
      <td>P9</td>
      <td>LLM-based</td>
      <td>Ordered</td>
      <td>
        <pre>name:
on:
  push:
    branches:
jobs:
  &lt;job_name&gt;:
    runs-on:
    steps:
      - name:
        uses:
      - name:
        run:</pre>
      </td>
      <td>519</td>
      <td>91</td>
      <td>17.53%</td>
      <td>Exact with Python reference matcher</td>
    </tr>
    <tr>
      <td>P10</td>
      <td>LLM-based</td>
      <td>Ordered</td>
      <td>
        <pre>name:
on:
  push:
    branches:
  pull_request:
jobs:
  build:
    runs-on:
    steps:
      - uses:
      - name:
        run:
      - name:
        run:</pre>
      </td>
      <td>812</td>
      <td>26</td>
      <td>3.20%</td>
      <td>Exact with Python reference matcher</td>
    </tr>
    <tr>
      <td>P11</td>
      <td>LLM-based</td>
      <td>Unordered</td>
      <td>
        <pre>name: &lt;workflow_name&gt;
on: &lt;trigger_event&gt;
jobs:
  &lt;job_name&gt;:
    runs-on: &lt;runner&gt;
    container:
      image: &lt;container_image&gt;
    steps:
      - name: &lt;step_name&gt;
        run: &lt;command&gt;</pre>
      </td>
      <td>1,056</td>
      <td>15</td>
      <td>1.42%</td>
      <td>Exact with Python reference matcher</td>
    </tr>
  </tbody>
</table>
