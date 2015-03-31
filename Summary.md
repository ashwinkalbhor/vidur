# Introduction #

Some of the recent advances made in Medical Image Analysis could be directly applied (or easily adapted) to Biological Image Analysis. However, the specific nature of biological images (higher resolution, different anatomy and functions, different contrast agents, etc.), requires specific image analysis methods. This is particularly true when dealing with in vivo microscopic images of cells and vessels.



# Details #
We are here attempted to design a robust , highly extensible framework that will provide image processing and analysis utilities at a single place. The framework has been tested by creating an open source utility for biological image analysis.


> Common analysis tasks in imaging are finding spots or “blobs” in images based on various criteria and obtaining structured information to describe them (positions of the blobs, their sizes, shapes, intensities, etc.).
ColonyCounter, presented here ,  can automatically detect and quantify spot-like objects within macroscope images.
Our efforts will be focused to the following generic problems applied to in vivo macroscopic images:
1.	quantitative analysis of macroscopic images,
2.	detection and quantification of variations in temporal sequences,
3.	construction of multiscale representations (from micro to macro).