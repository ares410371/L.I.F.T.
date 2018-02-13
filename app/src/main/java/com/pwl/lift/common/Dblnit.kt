package com.pwl.lift.common

import android.content.Context
import com.pwl.lift.R
import com.pwl.lift.db.dao.ExerciseDao
import com.pwl.lift.db.entity.Exercise

fun initExercises(context: Context, exerciseDao: ExerciseDao) {

	val backSquat = Exercise(0, context.getResources().getString(R.string.back_squats), R.mipmap.ic_squat, null)
	val frontSquats = Exercise(0, context.getResources().getString(R.string.front_squats), R.mipmap.ic_squat, null)
	val overhead_squats = Exercise(0, context.getResources().getString(R.string.overhead_squats), R.mipmap.ic_squat, null)
	val lunges = Exercise(0, context.getResources().getString(R.string.lunges), R.mipmap.ic_squat, null)
	val box_squats = Exercise(0, context.getResources().getString(R.string.box_squats), R.mipmap.ic_squat, null)
	val backSquatJumps = Exercise(0, context.getResources().getString(R.string.back_squat_jumps), R.mipmap.ic_squat, null)
	val goodMorning = Exercise(0, context.getResources().getString(R.string.good_morning), R.mipmap.ic_squat, null)
	val seatedGoogMorning = Exercise(0, context.getResources().getString(R.string.seated_good_morning), R.mipmap.ic_squat, null)
	val conventionalDeadlift = Exercise(0, context.getResources().getString(R.string.conventional_deadlift), R.mipmap.ic_deadlift, null)
	val sumoDeadlift = Exercise(0, context.getResources().getString(R.string.sumo_deadlift), R.mipmap.ic_deadlift, null)
	val blockPull = Exercise(0, context.getResources().getString(R.string.block_pull), R.mipmap.ic_deadlift, null)
	val deficitDealift = Exercise(0, context.getResources().getString(R.string.deficit_deadlift), R.mipmap.ic_deadlift, null)
	val snatchGripDeficitDeadlift = Exercise(0, context.getResources().getString(R.string.snatch_grip_deficit_deadlift), R.mipmap.ic_deadlift, null)
	val stiffLeggedDeadlift = Exercise(0, context.getResources().getString(R.string.stiff_legged_deadlift), R.mipmap.ic_deadlift, null)
	val clenans = Exercise(0, context.getResources().getString(R.string.cleans), R.mipmap.ic_deadlift, null)
	val highPulls = Exercise(0, context.getResources().getString(R.string.high_pulls), R.mipmap.ic_deadlift, null)
	val romanianDeadlift = Exercise(0, context.getResources().getString(R.string.romaniam_deadlift), R.mipmap.ic_deadlift, null)
	val flatBarbellBenchPress = Exercise(0, context.getResources().getString(R.string.bench_press), R.mipmap.ic_bench_press, null)
	val inclineBarbellBenchPress = Exercise(0, context.getResources().getString(R.string.incline_barbell_bench_press), R.mipmap.ic_bench_press, null)
	val dumbbellBenchPress = Exercise(0, context.getResources().getString(R.string.dumbell_bench_press), R.mipmap.ic_bench_press, null)
	val inclineDumbbellBenchPress = Exercise(0, context.getResources().getString(R.string.incline_dumbbell_bench_press), R.mipmap.ic_bench_press, null)
	val declineDumbbellBenchPress = Exercise(0, context.getResources().getString(R.string.decline_dumbbel_bench_press), R.mipmap.ic_bench_press, null)
	val blockPress = Exercise(0, context.getResources().getString(R.string.block_press), R.mipmap.ic_bench_press, null)
	val benchPressWithChains = Exercise(0, context.getResources().getString(R.string.bench_press_with_chains), R.mipmap.ic_bench_press, null)
	val floorPress = Exercise(0, context.getResources().getString(R.string.floor_press), R.mipmap.ic_bench_press, null)
	val closeGripBenchPress = Exercise(0, context.getResources().getString(R.string.close_grip_bench_press), R.mipmap.ic_bench_press, null)
	val reverseGripBenchPress = Exercise(0, context.getResources().getString(R.string.reverse_grip_bench_press), R.mipmap.ic_bench_press, null)
	val dips = Exercise(0, context.getResources().getString(R.string.dips), R.mipmap.ic_bench_press, null)
	val dumbbellFlies = Exercise(0, context.getResources().getString(R.string.dumbbell_flies), R.mipmap.ic_bench_press, null)
	val militaryPress = Exercise(0, context.getResources().getString(R.string.military_press), R.mipmap.ic_overhead_press, null)
	val dumbbellOverheadPress = Exercise(0, context.getResources().getString(R.string.dumbbell_overhead_press), R.mipmap.ic_overhead_press, null)
	val pushPress = Exercise(0, context.getResources().getString(R.string.push_press), R.mipmap.ic_overhead_press, null)
	val jerk = Exercise(0, context.getResources().getString(R.string.jerk), R.mipmap.ic_overhead_press, null)
	val snatchGripPress = Exercise(0, context.getResources().getString(R.string.snatch_grip_press), R.mipmap.ic_overhead_press, null)
	val seatedSnatchGripPress = Exercise(0, context.getResources().getString(R.string.seated_snatch_grip_press), R.mipmap.ic_overhead_press, null)
	val snatch = Exercise(0, context.getResources().getString(R.string.snatch), R.mipmap.ic_overhead_press, null)
	val cleanAndJerk = Exercise(0, context.getResources().getString(R.string.clean_and_jerk), R.mipmap.ic_overhead_press, null)
	val pullUps = Exercise(0, context.getResources().getString(R.string.pull_ups), R.mipmap.ic_bar_exercise, null)
	val chinUps = Exercise(0, context.getResources().getString(R.string.chin_ups), R.mipmap.ic_bar_exercise, null)
	val wideGripPullUps = Exercise(0, context.getResources().getString(R.string.wide_grip_pull_ups), R.mipmap.ic_bar_exercise, null)
	val muscleUps = Exercise(0, context.getResources().getString(R.string.muscle_ups), R.mipmap.ic_bar_exercise, null)
	val kettlebellSwing = Exercise(0, context.getResources().getString(R.string.kettlebell_swing), R.mipmap.ic_kettlebelt, null)
	val kettlebellTurkishGetUp = Exercise(0, context.getResources().getString(R.string.kettlebell_turkish_get_up), R.mipmap.ic_kettlebelt, null)
	val kettlebellSnatch = Exercise(0, context.getResources().getString(R.string.kettlebell_snatch), R.mipmap.ic_kettlebelt, null)
	val kettlebellClean = Exercise(0, context.getResources().getString(R.string.kettlebell_clean), R.mipmap.ic_kettlebelt, null)
	val kettlebellPress = Exercise(0, context.getResources().getString(R.string.kettlebell_press), R.mipmap.ic_kettlebelt, null)
	val kettlebellJerk = Exercise(0, context.getResources().getString(R.string.kettlebell_jerk), R.mipmap.ic_kettlebelt, null)
	val kettlebellArmBar = Exercise(0, context.getResources().getString(R.string.kettlebell_arm_bar), R.mipmap.ic_kettlebelt, null)
	val kettlebellOneArmSwing = Exercise(0, context.getResources().getString(R.string.kettlebell_one_arm_swing), R.mipmap.ic_kettlebelt, null)
	val kettlebellBentpress = Exercise(0, context.getResources().getString(R.string.kettlebell_bentpress), R.mipmap.ic_kettlebelt, null)


	exerciseDao.insertExercise(backSquat)
	exerciseDao.insertExercise(frontSquats)
	exerciseDao.insertExercise(overhead_squats)
	exerciseDao.insertExercise(lunges);
	exerciseDao.insertExercise(box_squats);
	exerciseDao.insertExercise(backSquatJumps);
	exerciseDao.insertExercise(goodMorning);
	exerciseDao.insertExercise(seatedGoogMorning);
	exerciseDao.insertExercise(conventionalDeadlift);
	exerciseDao.insertExercise(sumoDeadlift);
	exerciseDao.insertExercise(blockPull);
	exerciseDao.insertExercise(deficitDealift);
	exerciseDao.insertExercise(snatchGripDeficitDeadlift);
	exerciseDao.insertExercise(stiffLeggedDeadlift);
	exerciseDao.insertExercise(clenans);
	exerciseDao.insertExercise(highPulls);
	exerciseDao.insertExercise(romanianDeadlift);
	exerciseDao.insertExercise(flatBarbellBenchPress);
	exerciseDao.insertExercise(inclineBarbellBenchPress);
	exerciseDao.insertExercise(dumbbellBenchPress);
	exerciseDao.insertExercise(inclineDumbbellBenchPress);
	exerciseDao.insertExercise(declineDumbbellBenchPress);
	exerciseDao.insertExercise(blockPress);
	exerciseDao.insertExercise(benchPressWithChains);
	exerciseDao.insertExercise(floorPress);
	exerciseDao.insertExercise(closeGripBenchPress);
	exerciseDao.insertExercise(reverseGripBenchPress);
	exerciseDao.insertExercise(dips);
	exerciseDao.insertExercise(dumbbellFlies);
	exerciseDao.insertExercise(militaryPress);
	exerciseDao.insertExercise(dumbbellOverheadPress);
	exerciseDao.insertExercise(pushPress);
	exerciseDao.insertExercise(jerk);
	exerciseDao.insertExercise(snatchGripPress);
	exerciseDao.insertExercise(seatedSnatchGripPress);
	exerciseDao.insertExercise(snatch);
	exerciseDao.insertExercise(cleanAndJerk);
	exerciseDao.insertExercise(pullUps);
	exerciseDao.insertExercise(chinUps);
	exerciseDao.insertExercise(wideGripPullUps);
	exerciseDao.insertExercise(muscleUps);
	exerciseDao.insertExercise(kettlebellSwing);
	exerciseDao.insertExercise(kettlebellTurkishGetUp);
	exerciseDao.insertExercise(kettlebellSnatch);
	exerciseDao.insertExercise(kettlebellClean);
	exerciseDao.insertExercise(kettlebellPress);
	exerciseDao.insertExercise(kettlebellJerk);
	exerciseDao.insertExercise(kettlebellArmBar);
	exerciseDao.insertExercise(kettlebellOneArmSwing);
	exerciseDao.insertExercise(kettlebellBentpress);
}


