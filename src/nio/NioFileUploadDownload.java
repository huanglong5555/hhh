package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用MappedByteBuffer 高效复制文件 （应用于文件上传和下载）
 * 
 * @author huanglong
 *
 */
public class NioFileUploadDownload {
	public static void main(String[] args) {
		downLoadFileByMappedByteBuffer(
				"C:\\Users\\GrassMudHorse\\Desktop\\OS2_DLL_V1.020\\OS2_DLL_V1.020\\SensorDll_使用说明.txt",
				"C:\\Users\\GrassMudHorse\\Desktop\\OS2_DLL_V1.020\\OS2_DLL_V1.020\\SensorDll_使用说明3.txt");
		channelTransfor("C:\\Users\\GrassMudHorse\\Desktop\\OS2_DLL_V1.020\\OS2_DLL_V1.020\\SensorDll_使用说明.txt",
				"C:\\Users\\GrassMudHorse\\Desktop\\OS2_DLL_V1.020\\OS2_DLL_V1.020\\SensorDll_使用说明4.txt");
	}

	/**
	 * 利用MappedByteBuffer复制文件（主要应用于大文件的上传下载（和nio结合））
	 * 
	 * @param source
	 * @param des
	 */
	public static void downLoadFileByMappedByteBuffer(String source, String des) {
		long timeBegin = System.currentTimeMillis();
		ByteBuffer buffer = getFileMappedBuffer(source);
		writeToFile(des, buffer);
		long timeEnd = System.currentTimeMillis();
		System.out.println("Read and write time: " + (timeEnd - timeBegin) + "ms");
	}

	/**
	 * 通过 channel tansfor 复制文件（速度快）
	 * 
	 * @param source
	 * @param des
	 */
	public static void channelTransfor(String source, String des) {
		RandomAccessFile fromFile = null;
		RandomAccessFile toFile = null;
		try {
			long timeBegin = System.currentTimeMillis();

			fromFile = new RandomAccessFile(source, "rw");
			FileChannel fromChannel = fromFile.getChannel();
			toFile = new RandomAccessFile(des, "rw");
			FileChannel toChannel = toFile.getChannel();

			long position = 0;
			long count = fromChannel.size();
			System.out.println(count);
			fromChannel.transferTo(position, count, toChannel);

			long timeEnd = System.currentTimeMillis();
			System.out.println("Channel Transfer time: " + (timeEnd - timeBegin) + "ms");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fromFile != null) {
					fromFile.close();
				}
				if (toFile != null) {
					toFile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void writeToFile(String des, ByteBuffer mbb) {
		RandomAccessFile aFile = null;
		FileChannel fc = null;
		try {
			aFile = new RandomAccessFile(des, "rw");
			fc = aFile.getChannel();
			while (mbb.hasRemaining()) {
				fc.write(mbb);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (aFile != null) {
					aFile.close();
				}
				if (fc != null) {
					fc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static ByteBuffer getFileMappedBuffer(String path) {
		RandomAccessFile aFile = null;
		FileChannel fc = null;
		try {
			aFile = new RandomAccessFile(path, "rw");
			fc = aFile.getChannel();
			long timeBegin = System.currentTimeMillis();
			MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, aFile.length());
			long timeEnd = System.currentTimeMillis();
			System.out.println("Read time: " + (timeEnd - timeBegin) + "ms");
			return mbb;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (aFile != null) {
					aFile.close();
				}
				if (fc != null) {
					fc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
