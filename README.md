ImageSelectionExperimentMTurk
=============================

 **Backup** of my Amazon Mechanical Turk depolyment work.
 --------------------------------------------------------

**Introduction:**

* We were wondering what factors have impact on people's performance in crowdsourcing and how these factors influence people.

**Basic Idea:**

* We ask people to choose the most clear image among a bunch of blurred images. Then, we use our performance metric to evaluate their performances and conclude the results.

**Dataset:**

* The dataset is from [Infolab](http://infolab.stanford.edu/) at Stanford University. This dataset comes up with 72 images and their corresponding blurred images. Each image is blurred with Guassian function and the degree of blur is controlled by people, so we know the actual degree of blur.


**Platform:**

* The crowdsourcing platform we choose is [Amazon Mechanical Turk](https://www.mturk.com/mturk/welcome). This project is written in Java. The reference library is the Java API package provided by Amazon.

**Algorithms:**

* Because divide-and-conquer is relatively a good way to approach answer, we make our image selection task iterative. There are two algorithms we test in this iterative environment. The first only is named Tournament algorithm, which is parallel and behaves like a tree. The second is named bubble algorithm, which is sequential and behaves like a bubble.

**Remark:**

* I also gave a talk in a [workshop](http://systems.soe.ucsc.edu/node/545). You can find more information in my talk, such as my [slides](http://systems.soe.ucsc.edu/sites/default/files/images/Huang_Symp2011.pdf).
